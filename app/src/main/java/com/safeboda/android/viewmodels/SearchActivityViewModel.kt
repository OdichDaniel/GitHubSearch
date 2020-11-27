package com.safeboda.android.viewmodels

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
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

                Log.d("flutterwave", "User found:"+response.gitHubUser.toString())

                showProfileContainer.postValue(true)
                userMutableLiveData.postValue(response.gitHubUser)
            }
        }
    }

    private val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->

        Log.d("flutterwave", "Error:"+throwable.message)
    }



}