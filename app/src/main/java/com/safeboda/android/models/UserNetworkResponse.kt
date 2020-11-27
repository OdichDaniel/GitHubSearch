package com.safeboda.android.models

import com.safeboda.android.data.GitHubUser

/**
 *  Holds response of the network request to fetch user
 *
 * @property gitHubUser, the response returned
 * @property message, the message in case user not found
 * @property userFound, true is user was found
 */
data class UserNetworkResponse(var gitHubUser: GitHubUser? = null, var message: String? = null, var userFound: Boolean = false)