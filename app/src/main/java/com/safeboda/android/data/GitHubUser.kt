package com.safeboda.android.data

import org.parceler.Parcel
import org.parceler.ParcelConstructor

// Represents a github user
@Parcel
data class GitHubUser @ParcelConstructor constructor(
    var bio: String? = null,
    var blog: String? = null,
    var company: String? = null,
    var created_at: String? = null,
    var email: String? = null,
    var followers: Int? = 0,
    var following: Int = 0,
    var location: String? = null,
    var name: String? = null,
    var public_gists: Int? = null,
    var public_repos: Int? = null,
    var twitter_username: String? = null,
    var updated_at: String? = null

): User(){

    // org.parcel always needs this empty constructor
    constructor(): this(bio = "",
        blog = "",
        company = "",
        created_at = "",
        email = "",
        followers = 0,
        following = 0,
        location = "",
        name = "",
        public_gists = 0,
        public_repos = 0,
        twitter_username = "",
        updated_at = ""){

    }

    override fun toString(): String {
        return "GitHubUser(bio=$bio, blog=$blog, company=$company, created_at=$created_at, email=$email, followers_url=$followers_url, following=$following, location=$location, name=$name, public_gists=$public_gists, public_repos=$public_repos, twitter_username=$twitter_username, updated_at=$updated_at)"
    }
}