package com.tugas.evoting.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.tugas.evoting.R
import com.tugas.evoting.databinding.CalonActivityBinding
import com.tugas.evoting.viewmodel.CalonViewModel
import com.tugas.evoting.viewmodel.ListCalonAdapter

class ListCalonActivity: AppCompatActivity() {
    private lateinit var binding: CalonActivityBinding
    private lateinit var viewModel: CalonViewModel
    private lateinit var adapter: ListCalonAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.calon_activity)
        viewModel = ViewModelProviders.of(this).get(CalonViewModel::class.java)
        binding.itemCalon = viewModel
        setupRecyclerView()
        observerLiveData()
        viewModel.getListCalon()
    }

    private fun observerLiveData() {
        viewModel.listCalon.observe(this, Observer {
            adapter.seData(it!!.data)
            adapter.notifyDataSetChanged()
        })
        viewModel.error.observe(this, Observer {

        })
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.rcCalon.layoutManager = layoutManager
        adapter = ListCalonAdapter(this)
        binding.rcCalon.adapter = adapter

    }
}