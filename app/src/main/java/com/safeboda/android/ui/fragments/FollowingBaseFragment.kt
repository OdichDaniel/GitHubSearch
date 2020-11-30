package com.safeboda.android.ui.fragments

import androidx.fragment.app.Fragment

// Fragment that extend this will have there loadMore method called by
// parent activity nestedScrollView scroll listener
abstract class FollowingBaseFragment: Fragment() {

    abstract fun loadMore()
}