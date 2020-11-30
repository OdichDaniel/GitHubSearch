package com.safeboda.android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.safeboda.android.R
import com.safeboda.android.databinding.ListFooterItemViewBinding

/**
 * The fragment binds [Followings, Followers] to the view pager
 * @constructor
 * TODO
 *
 * @param fragmentManager
 * @param behavior
 */
class ReposLoadStateAdapter(private val retry: () -> Unit): LoadStateAdapter<ReposLoadStateAdapter.ReposLoadStateViewHolder>() {


    override fun onBindViewHolder(holder: ReposLoadStateViewHolder, loadState: LoadState) {

        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ReposLoadStateViewHolder {

        return ReposLoadStateViewHolder.create(parent, retry)
    }

    /**
     * The loading view of the recycler list items that implement endless scrolling
     *
     * @property  binding of the footer layout
     */
    class ReposLoadStateViewHolder(private val binding: ListFooterItemViewBinding, retry: () -> Unit): RecyclerView.ViewHolder(binding.root) {

        init {

            binding.retryButton.setOnClickListener {
                retry.invoke()
            }
        }

        // We will bind to the UI from this method
        fun bind(loadState: LoadState){

            if (loadState is LoadState.Error) {
                binding.errorMsg.text = loadState.error.localizedMessage
            }
            binding.progressBar.visibility = if(loadState is LoadState.Loading) View.VISIBLE else View.GONE
            binding.retryButton.visibility = if(loadState !is LoadState.Loading) View.VISIBLE else View.GONE
            binding.errorMsg.visibility = if(loadState !is LoadState.Loading) View.VISIBLE else View.GONE
        }


        // Create view

        companion object{

            fun create(parent: ViewGroup, retry: () -> Unit): ReposLoadStateViewHolder{

                val view = LayoutInflater.from(parent.context).inflate(R.layout.list_footer_item_view, parent, false)

                val binding = ListFooterItemViewBinding.bind(view)

                return ReposLoadStateViewHolder(binding, retry)
            }
        }

    }


}