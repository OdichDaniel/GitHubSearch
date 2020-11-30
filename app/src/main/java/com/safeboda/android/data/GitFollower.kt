package com.safeboda.android.data

import org.parceler.Parcel

// Git follower following on Github
@Parcel
class GitFollower: User(){

    override fun toString(): String {
        return "avatar_url=${avatar_url}"
    }
}