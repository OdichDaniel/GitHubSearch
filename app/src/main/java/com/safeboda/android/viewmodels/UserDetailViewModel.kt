package com.safeboda.android.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.paging.PagingData
import com.safeboda.android.data.GitFollower
import com.safeboda.android.data.GitHubUser
import com.safeboda.android.data.repository.FollowerRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

// This view model will serve userDetailActivity and its fragments
class UserDetailViewModel @Inject constructor(val followerRepository: FollowerRepository): ViewModel() {

    // Fetch user followers
    fun fetchUserFollowers(gitHubUser: GitHubUser) = liveData<PagingData<GitFollower>> (coroutineExceptionHandler){

        emitSource(followerRepository.fetchFollowers(gitHubUser))
    }

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->


    }


}