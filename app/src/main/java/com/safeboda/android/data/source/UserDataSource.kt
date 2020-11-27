package com.safeboda.android.data.source

import android.util.Log
import com.google.gson.Gson
import com.safeboda.android.api.NetworkApi
import com.safeboda.android.data.GitHubUser
import com.safeboda.android.models.UserNetworkResponse
import javax.inject.Inject

// Github user data source
class UserDataSource @Inject constructor(val networkApi: NetworkApi, val gson: Gson) {

    /**
     * Get user by name
     * @param userName
     * @return
     */
    suspend fun getUser(userName: String): UserNetworkResponse{

         val userNetworkResponse = UserNetworkResponse()

        Log.d("flutterwave", "Coming here")
        val response = networkApi.getUser(userName)

        Log.d("flutterwave", "status:"+response.code())
        if(response.isSuccessful){

            response.body()?.let {

                Log.d("flutterwave", "And here")
                val user = gson.fromJson<GitHubUser>(it.string(), GitHubUser::class.java)

                userNetworkResponse.gitHubUser = user
                userNetworkResponse.userFound = true
            }?: run{

                userNetworkResponse.message = "Error occurred"
            }


        }else{

            Log.d("fluttewave", "Here")

            userNetworkResponse.message = response.errorBody()?.string()
        }

        return userNetworkResponse

    }
}