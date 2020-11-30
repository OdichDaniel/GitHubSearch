package com.safeboda.android.ui.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.safeboda.android.R
import com.safeboda.android.core.utils.Constants
import com.safeboda.android.data.GitHubUser
import com.safeboda.android.ui.fragments.FollowersFragment
import org.parceler.Parcels

class FollowingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_following)
        setSupportActionBar(findViewById(R.id.toolbar))

        if(savedInstanceState == null){

            val whichFragment = intent?.getStringExtra(WHICH_FRAGMENT)
            val gitHubUser = Parcels.unwrap(intent?.getParcelableExtra(Constants.USER)) as GitHubUser
            var fragment: Fragment? = null

            // Start a fragment based on which fragment was asked to be started
            when(whichFragment){

                FOLLOWER_FRAGMENT -> fragment = FollowersFragment()
                FOLLOWING_FRAGMENT -> { }
            }

            val bundle = Bundle()
            bundle.putParcelable(Constants.USER, Parcels.wrap(gitHubUser))
            fragment?.arguments = bundle

            supportFragmentManager.beginTransaction().add(R.id.followingContainer, fragment!!).commit()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        finish()
        return super.onOptionsItemSelected(item)
    }

    companion object{

        val WHICH_FRAGMENT = "which_fragment"
        val FOLLOWER_FRAGMENT = "follower_fragment"
        val FOLLOWING_FRAGMENT = "following_fragment"
    }
}