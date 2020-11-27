package com.safeboda.android.api

import com.safeboda.android.data.GitFollower
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

/**
 *  Backend apis to github
 *
 */
interface NetworkApi {

    // User by username
    @GET("/users/{userName}")
    suspend fun getUser(@Path("userName") userName: String): Response<ResponseBody>

    // Get followers to a user
    @GET
    suspend fun getFollowers(@Url url: String): Response<List<GitFollower>>
}