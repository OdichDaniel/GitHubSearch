package com.safeboda.android.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.safeboda.android.R
import com.safeboda.android.data.GitFollower
import com.safeboda.android.databinding.FollowerListItemBinding

class FollowerRecyclerAdapter: PagingDataAdapter <GitFollower, FollowerRecyclerAdapter.ViewItemHolder>(DIFF_UTIL) {

    override fun onBindViewHolder(holder: ViewItemHolder, position: Int) {

        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewItemHolder {

        return ViewItemHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.follower_list_item, parent, false))
    }

    inner class ViewItemHolder(private val binding: FollowerListItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(gitFollower: GitFollower?){

            Log.d("flutterwave", "follo:"+gitFollower?.followers_url)
            binding.gitFollower = gitFollower
        }
    }

    companion object{

        val DIFF_UTIL = object: DiffUtil.ItemCallback<GitFollower>(){
            override fun areItemsTheSame(oldItem: GitFollower, newItem: GitFollower): Boolean {

                Log.d("flutterwave", "Old:"+oldItem.id + " new:"+newItem.id)
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: GitFollower, newItem: GitFollower): Boolean {

                // Lets rely on url to different contents
                return oldItem.equals(newItem)
            }


        }
    }

}