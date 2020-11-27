package com.safeboda.android.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.safeboda.android.R
import com.safeboda.android.core.di.DaggerCoreComponent
import com.safeboda.android.core.di.modules.CoreModule
import com.safeboda.android.core.utils.ViewModelFactory
import com.safeboda.android.di.DaggerAppComponent
import com.safeboda.android.viewmodels.UserDetailViewModel
import javax.inject.Inject

/**
 *  This fragment lists the followers to the user
 */
class FollowersFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: UserDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val coreComponent = DaggerCoreComponent.builder().coreModule(CoreModule(requireContext())).build()
        DaggerAppComponent.builder().coreComponent(coreComponent).build().inject(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_followers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(UserDetailViewModel::class.java)


    }
}