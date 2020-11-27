package com.safeboda.android.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.safeboda.android.ui.fragments.FollowersFragment
import com.safeboda.android.ui.fragments.FollowingsFragment

/**
 * The fragment binds [Followings, Followers] to the view pager
 * @constructor
 * TODO
 *
 * @param fragmentManager
 * @param behavior
 */
class UserFollowingsFragmentAdapter(fragmentManager: FragmentManager, behavior: Int): FragmentStatePagerAdapter(fragmentManager, behavior) {

    override fun getPageTitle(position: Int): CharSequence? {
        return return when(position){

            0 -> "Followers"

            1 -> "Followings"

            else -> "Followers"
        }
    }

    override fun getItem(position: Int): Fragment {

        return when(position){

            0 -> FollowersFragment()

            1 -> FollowingsFragment()

            else -> FollowersFragment()
        }
    }

    override fun getCount(): Int {

        return 2
    }
}