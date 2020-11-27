package com.safeboda.android.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.safeboda.android.data.GitFollower
import com.safeboda.android.data.GitHubUser
import com.safeboda.android.data.source.FollowerDataSource
import javax.inject.Inject

// User following repository
class FollowerRepository @Inject constructor(val followerDataSource: FollowerDataSource) {

    fun fetchFollowers(gitHubUser: GitHubUser): LiveData<PagingData<GitFollower>>{

        // Set git user before any methods are called
        followerDataSource.gitHubUser = gitHubUser

        val pagingConfig = PagingConfig(FollowerDataSource.PAGE_SIZE, enablePlaceholders = true)

        return Pager(pagingConfig, pagingSourceFactory = {followerDataSource}).liveData
    }
}