package com.safeboda.android.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.safeboda.android.data.GitHubUser
import com.safeboda.android.data.repository.UserRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Search activity view model
 * @property userRepository, the repository to fetch user
 */
class SearchActivityViewModel @Inject constructor(val userRepository: UserRepository): ViewModel() {

    val userMutableLiveData = MutableLiveData<GitHubUser>()

    // Show top progress bar
    val showProgressBar = MutableLiveData<Boolean>()

    // Show user profile container
    val showProfileContainer = MutableLiveData<Boolean>()

    var user: GitHubUser? = null

    // Get user by name
    fun getUserByName(userName: String){

        viewModelScope.launch (coroutineExceptionHandler){

            // Show progressbar
            showProgressBar.postValue(true)

            // Hide container for a new search
            showProfileContainer.postValue(false)

            // Get user
            val response = userRepository.getUserByName(userName)

            // Hide progressbar
            showProgressBar.postValue(false)

            if(response.userFound){

                showProfileContainer.postValue(true)

                user = response.gitHubUser
                userMutableLiveData.postValue(response.gitHubUser)
            }
        }
    }

    private val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->

        // Hide progressbar
        showProgressBar.postValue(false)
    }



}