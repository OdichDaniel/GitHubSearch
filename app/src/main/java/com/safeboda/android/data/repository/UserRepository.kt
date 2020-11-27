package com.safeboda.android.data.repository

import com.safeboda.android.data.source.UserDataSource
import com.safeboda.android.models.UserNetworkResponse
import javax.inject.Inject

class UserRepository @Inject constructor(val userDataSource: UserDataSource) {

    suspend fun getUserByName(userName: String): UserNetworkResponse{

        return userDataSource.getUser(userName)
    }
}