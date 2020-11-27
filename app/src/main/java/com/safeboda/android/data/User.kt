package com.safeboda.android.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * This class represents a git user
 */
@Parcelize
open class User(
    open var avatar_url: String? = null,
    open var events_url: String? = null,
    open var followers_url: String? = null,
    open var following_url: String? = null,
    open var gists_url: String? = null,
    open var gravatar_id: String? = null,
    open var html_url: String? = null,
    open var id: Int = 0,
    open var login: String? = null,
    open var node_id: String? = null,
    open var organizations_url: String? = null,
    open var received_events_url: String? = null,
    open var repos_url: String? = null,
    open var site_admin: Boolean = false,
    open var starred_url: String? = null,
    open var subscriptions_url: String? = null,
    open var type: String? = null,
    open var url: String? = null
): Parcelable