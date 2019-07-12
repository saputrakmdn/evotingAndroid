package com.tugas.evoting.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log.w
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.tugas.evoting.R
import com.tugas.evoting.viewmodel.DataPemilihViewModel

class LoginActivity: AppCompatActivity() {
    var etNik : EditText? = null
    var btn : Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        etNik = findViewById(R.id.inputNik)
        btn = findViewById(R.id.btnMasuk)
        val viewModel = ViewModelProviders.of(this).get(DataPemilihViewModel::class.java)
    }
}