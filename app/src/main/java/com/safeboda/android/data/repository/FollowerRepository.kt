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

class FollowerRepository @Inject constructor(val followerDataSource: FollowerDataSource) {

    fun fetchFollowers(gitHubUser: GitHubUser): LiveData<PagingData<GitFollower>>{

        // Let's set git user to the datasource before we use it
        followerDataSource.gitHubUser = gitHubUser

        var pagingConfig = PagingConfig(FollowerDataSource.PAGE_SIZE, enablePlaceholders = true)

        return Pager(pagingConfig, pagingSourceFactory = {followerDataSource}).liveData
    }
}