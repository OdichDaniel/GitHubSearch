package com.safeboda.android.api

import com.safeboda.android.data.GitFollower
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
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
    @GET("/users/{username}/followers")
    suspend fun getFollowers(@Path("username") userName: String, @Query("per_page") pageSize: Int, @Query("page") pageNumber: Int): Response<List<GitFollower>>
}