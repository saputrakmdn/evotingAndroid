package com.tugas.evoting.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log.w
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tugas.evoting.R
import com.tugas.evoting.model.DataCalon
import com.tugas.evoting.view.DetailCalonActivity

class ListCalonAdapter: RecyclerView.Adapter<ListCalonAdapter.ListCalonViewHolder> {

    lateinit var listCalon : List<DataCalon>
    lateinit var mContext : Context
    constructor(){

    }
    constructor(mContext: Context, listCalon: List<DataCalon>){
        this.listCalon = listCalon
        this.mContext = mContext
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListCalonViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.list_calon, p0, false)
        view.setOnClickListener {
            val calon = listCalon[p1]
            val intent = Intent(mContext, DetailCalonActivity::class.java)
            intent.putExtra("id_calon", calon.id)
            intent.putExtra("nama", calon.nama)
            intent.putExtra("visi", calon.visi)
            intent.putExtra("misi", calon.misi)
            intent.putExtra("foto", calon.foto)
            mContext.startActivity(intent)
        }
        return ListCalonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCalon.size
    }

    override fun onBindViewHolder(p0: ListCalonViewHolder, p1: Int) {
        val calon = listCalon[p1]
        val urlphoto = "http://172.16.10.12:8000/${calon.foto}"
        w("tag", "tes$urlphoto")
        p0.nama.text = calon.nama
        Glide.with(mContext).load(urlphoto).apply(RequestOptions().placeholder(R.drawable.debate)).into(p0.foto)

    }


    class ListCalonViewHolder(item: View):RecyclerView.ViewHolder(item){
        var nama :TextView
        var foto : ImageView
        init {
            nama = item.findViewById(R.id.nama)
            foto = item.findViewById(R.id.foto)

        }


    }
}