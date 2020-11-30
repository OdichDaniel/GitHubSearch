package com.safeboda.android.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.safeboda.android.R
import com.safeboda.android.core.di.DaggerCoreComponent
import com.safeboda.android.core.di.modules.CoreModule
import com.safeboda.android.core.utils.Constants
import com.safeboda.android.core.utils.ViewModelFactory
import com.safeboda.android.di.DaggerAppComponent
import com.safeboda.android.viewmodels.SearchActivityViewModel
import com.safeboda.android.databinding.ActivitySearchBinding
import kotlinx.android.synthetic.main.content_search.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.parceler.Parcels
import javax.inject.Inject

class SearchActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: SearchActivityViewModel

    // Lets create a job for submitting the query text, this allows us the cancel the previous on when a new one arrives
    private var submitQueryJob: Job? = null

    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        setSupportActionBar(findViewById(R.id.toolbar))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val coreComponent = DaggerCoreComponent.builder().coreModule(CoreModule(this)).build()
        DaggerAppComponent.builder().coreComponent(coreComponent).build().inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory).get(SearchActivityViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel


        // Start user detail on click
        userContainer.setOnClickListener {

            val intent  = Intent(this, UserDetailActivity::class.java)
            intent.putExtra(Constants.USER, Parcels.wrap(viewModel.user))

            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_search, menu)

        val searchView = menu.findItem(R.id.search_bar).actionView as SearchView

        searchView.setOnQueryTextListener(this)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == android.R.id.home){

            this.finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {

        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {

        // Cancel any previous pending jobs

        submitQueryJob?.cancel()

        submitQueryJob = lifecycleScope.launch{

            delay(600)
            newText?.let { submitQuery(it) }
        }

        return true
    }

    private fun submitQuery(query: String){

        viewModel.getUserByName(query)
    }

}