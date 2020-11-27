package com.safeboda.android.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.safeboda.android.R
import com.safeboda.android.adapter.UserFollowingsFragmentAdapter
import com.safeboda.android.core.utils.Constants
import com.safeboda.android.data.GitHubUser
import com.safeboda.android.databinding.ActivityUserDetailBinding
import kotlinx.android.synthetic.main.content_user_detail.*

class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding

    private var gitHubUser: GitHubUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gitHubUser = intent.getParcelableExtra(Constants.USER)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)

        binding.user = gitHubUser

        setSupportActionBar(findViewById(R.id.toolbar))

        // Set up viewpager
        viewPager.setUp()
    }


    private fun ViewPager.setUp(){

        // Set tabLayout with view pager
        tabLayout.setupWithViewPager(this)

        adapter = UserFollowingsFragmentAdapter(supportFragmentManager,0)
    }
}