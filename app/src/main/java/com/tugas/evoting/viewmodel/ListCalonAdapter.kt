package com.tugas.evoting.viewmodel

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.tugas.evoting.R
import com.tugas.evoting.databinding.ListCalonBinding
import com.tugas.evoting.model.ResponseDataCalon

class ListCalonAdapter(val context: Context): RecyclerView.Adapter<ListCalonAdapter.IteMCalonViewHolder>() {


    private var listCalon : MutableList<ResponseDataCalon.DataCalon> = mutableListOf()
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): IteMCalonViewHolder {
        val binding: ListCalonBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.list_calon, p0, false)
        return IteMCalonViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  listCalon.size
    }

   override fun onBindViewHolder(p0: IteMCalonViewHolder, p1: Int) {
       p0.bindData(listCalon[p0.adapterPosition])

    }
    fun seData(list: MutableList<ResponseDataCalon.DataCalon>){
        this.listCalon = list
    }
    class IteMCalonViewHolder(private val binding: ListCalonBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindData(model: ResponseDataCalon.DataCalon){
            val viewModel = ItemCalonViewModel(model)
            binding.itemCalon = viewModel

        }

    }

}


