package com.safeboda.android.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.safeboda.android.R
import com.safeboda.android.adapter.FollowerRecyclerAdapter
import com.safeboda.android.adapter.ReposLoadStateAdapter
import com.safeboda.android.core.di.DaggerCoreComponent
import com.safeboda.android.core.di.modules.CoreModule
import com.safeboda.android.core.utils.Constants
import com.safeboda.android.core.utils.ViewModelFactory
import com.safeboda.android.data.GitFollower
import com.safeboda.android.data.GitHubUser
import com.safeboda.android.databinding.FragmentFollowersBinding
import com.safeboda.android.di.DaggerAppComponent
import com.safeboda.android.ui.activities.FollowingActivity
import com.safeboda.android.viewmodels.UserDetailViewModel
import kotlinx.android.synthetic.main.fragment_followers.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.parceler.Parcels
import javax.inject.Inject

/**
 *  This fragment lists the followers to the user
 */
class FollowersFragment : FollowingBaseFragment(), Observer<PagingData<GitFollower>> {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: UserDetailViewModel

    private var gitHubUser: GitHubUser? = null

    // Recycler adapter
    private lateinit var followerRecyclerAdapter: FollowerRecyclerAdapter

    private lateinit var binding: FragmentFollowersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val coreComponent = DaggerCoreComponent.builder().coreModule(CoreModule(requireContext())).build()
        DaggerAppComponent.builder().coreComponent(coreComponent).build().inject(this)

        arguments?.let {

            gitHubUser = Parcels.unwrap(it.getParcelable(Constants.USER)) as? GitHubUser
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_followers, container, false)
        return binding.root
    }

    // Called when requested to load more
    override fun loadMore() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(UserDetailViewModel::class.java)

        followerRecyclerView?.setup()

        gitHubUser?.let {

            viewModel.fetchUserFollowers(it).observe(viewLifecycleOwner, this)
        }
    }

    override fun onResume() {
        super.onResume()

        ((requireActivity() as FollowingActivity)).supportActionBar?.title = "Followers(${gitHubUser?.followers})"
        ((requireActivity() as FollowingActivity)).supportActionBar?.subtitle = gitHubUser?.name
    }

    override fun onChanged(t: PagingData<GitFollower>?) {

        t?.let {

            // Update on the main thread
            lifecycleScope.launch(Dispatchers.Main) {
                followerRecyclerAdapter.submitData(it)
            }
        }

    }

    private fun RecyclerView.setup(){

        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))

        followerRecyclerAdapter = FollowerRecyclerAdapter()
        adapter = followerRecyclerAdapter

        // Load state listener
        followerRecyclerAdapter.addLoadStateListener {

            // Refresh is when we first load our list, show progress screen
            if(it.source.refresh == LoadState.Loading && followerRecyclerAdapter.itemCount <= 0){

                loadingProgressBar.visibility = View.VISIBLE
               // viewModel.showProgressLayout.postValue(true)
                //viewModel.showEmptyProductLayout.postValue(false)
            }

            // Refresh finished loading
            else if(it.source.refresh is LoadState.NotLoading){

                //xmallProductViewModel.showProgressLayout.postValue(false)
                loadingProgressBar.visibility = View.GONE
            }

            if(followerRecyclerAdapter.itemCount   <= 0 && it.source.append.endOfPaginationReached){
                // Show items are empty
                //xmallProductViewModel.showEmptyProductLayout.postValue(true)
            }
        }

        followerRecyclerAdapter.withLoadStateFooter(footer =  ReposLoadStateAdapter(retry = {

            // Retry our network errors here
        }))

    }
}