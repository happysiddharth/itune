package com.example.basetemplate.ui.main

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basetemplate.R
import com.example.basetemplate.data.model.ItuneResponse
import com.example.basetemplate.di.component.ActivityComponent
import com.example.basetemplate.ui.base.BaseActivity
import com.example.basetemplate.ui.main.addresses.AddressAdapter

class HomeActivity() : BaseActivity<HomeViewModel>() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var addressAdapter: AddressAdapter
    private val list = ArrayList<ItuneResponse.Result>()

    override fun provideLayoutId(): Int = R.layout.home_layout


    override fun setupView(savedInstanceState: Bundle?) {
        recyclerView = findViewById(R.id.addresses)
        addressAdapter = AddressAdapter(list,this.lifecycle)
        recyclerView.apply {
            adapter = addressAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        supportActionBar?.title = "Address"
        menuInflater.inflate(R.menu.search_menu_home,menu)
        val search = menu?.findItem(R.id.search)
        val searchView = search?.actionView as SearchView
        searchView.queryHint = getString(R.string.address)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.pushCity(newText.toString())
                com.example.basetemplate.util.log.Logger.e("SIdd",newText.toString())
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)

    }



    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setUpToolBar(): Toolbar = findViewById(R.id.my_toolbar)

    override fun setObservers() {
        super.setObservers()
        viewModel.address.observe(this){
            list.clear()
            it?.let {
                list.addAll(it)
            }
            addressAdapter.notifyDataSetChanged()

        }

    }



}