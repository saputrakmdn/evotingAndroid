package com.tugas.evoting.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log.w
import com.bumptech.glide.Glide
import com.tugas.evoting.R
import kotlinx.android.synthetic.main.vote_activity.*

class DetailCalonActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vote_activity)
        val nama = intent.getStringExtra("nama")
        val visicalon = intent.getStringExtra("visi")
        val misicalon = intent.getStringExtra("misi")
        val foto = intent.getStringExtra("foto")
        w("tag", "$foto")
        val fotourl = "http://172.16.10.12:8000/${foto}"
        visi.text = visicalon
        misi.text = misicalon
        calon_nama.text = nama
        Glide.with(this).load(fotourl).into(image_calon)
    }
}