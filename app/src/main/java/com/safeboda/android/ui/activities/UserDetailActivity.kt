package com.safeboda.android.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.safeboda.android.R
import com.safeboda.android.core.utils.Constants
import com.safeboda.android.data.GitHubUser
import com.safeboda.android.databinding.ActivityUserDetailBinding
import kotlinx.android.synthetic.main.content_user_detail.*
import org.parceler.Parcels

class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding

    private var gitHubUser: GitHubUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gitHubUser = Parcels.unwrap(intent.getParcelableExtra(Constants.USER))

        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)

        binding.user = gitHubUser

        setSupportActionBar(findViewById(R.id.toolbar))

        myButton.setOnClickListener {

            val intent = Intent(this, FollowingActivity::class.java)
            intent.putExtra(Constants.USER, Parcels.wrap(gitHubUser))
            intent.putExtra(FollowingActivity.WHICH_FRAGMENT, FollowingActivity.FOLLOWER_FRAGMENT)
            startActivity(intent)
        }

    }

}