package com.safeboda.android.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.safeboda.android.R
import com.safeboda.android.core.di.DaggerCoreComponent
import com.safeboda.android.core.di.modules.CoreModule
import com.safeboda.android.core.utils.ViewModelFactory
import com.safeboda.android.di.DaggerAppComponent
import com.safeboda.android.viewmodels.MainActivityViewModel
import javax.inject.Inject

/**
 * Home activity
 *
 */
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val coreComponent = DaggerCoreComponent.builder().coreModule(CoreModule(this)).build()
        DaggerAppComponent.builder().coreComponent(coreComponent).build().inject(this)

        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))


        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}