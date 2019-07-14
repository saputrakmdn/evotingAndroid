package com.tugas.evoting.view

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.util.Log.w
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.tugas.evoting.R
import com.tugas.evoting.data.SharePref
import com.tugas.evoting.model.DataPemilih
import com.tugas.evoting.service.Const
import com.tugas.evoting.viewmodel.DataPemilihViewModel

class LoginActivity: AppCompatActivity() {
    var etNik : EditText? = null
    var btn : Button? = null
    var ilyt: TextInputLayout? = null
    internal lateinit var set: SharePref



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        etNik = findViewById(R.id.inputNik)
        btn = findViewById(R.id.btnMasuk)
        set = SharePref(this)
        ilyt = findViewById(R.id.text_input_layout)
        val viewModel = ViewModelProviders.of(this).get(DataPemilihViewModel::class.java)
       viewModel.dataPemilih!!.observeForever{
            btn!!.setOnClickListener {
                xx ->
                for (data in it!!){
                    val login = etNik!!.text.toString()
                    val status = data.status_vote
                    val id = data.id
                    val nik = data.nik
                    if (login == nik){
                        if (status == "0"){
                            Toast.makeText(this, "TES", Toast.LENGTH_SHORT).show()
                            set.updateSetting(Const.PREF_MY_ID, id)
                            startActivity(Intent(this, ListCalonActivity::class.java))
                            finish()
                        }else{
                            ilyt!!.error = "Anda Telah Melakukan vote"
                        }
                    }else if (status != "0"){
                        ilyt!!.error = "Anda Telah Melakukan vote"
                    }
                    else{
                        ilyt!!.error = "Nik Anda tidak terdaftar"
                    }
                }

//                val nik = it!!.get(0).nik

                w("o", "Tes ")

            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }
}