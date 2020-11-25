package com.safeboda.android.viewmodels

import androidx.lifecycle.ViewModel
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

class MainActivityViewModel @Inject constructor(@Named("cachingRetrofit") val retrofit: Retrofit): ViewModel() {

    fun hello(){

    }
}