package com.safeboda.android.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// Represents a github user

@Parcelize
data class GitHubUser(
    var bio: String? = null,
    var blog: String? = null,
    var company: String? = null,
    var created_at: String? = null,
    var email: String? = null,
    var followers: Int? = null,
    var following: Int = 0,
    var location: String? = null,
    var name: String? = null,
    var public_gists: Int? = null,
    var public_repos: Int? = null,
    var twitter_username: String? = null,
    var updated_at: String? = null

): User(), Parcelable{


}