package com.tugas.evoting.view

import android.app.AlertDialog
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.util.Log.w
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.tugas.evoting.R
import com.tugas.evoting.data.SharePref
import com.tugas.evoting.model.DataPemilih
import com.tugas.evoting.service.Const
import com.tugas.evoting.viewmodel.DataPemilihViewModel
import dmax.dialog.SpotsDialog
import android.app.ProgressDialog
import android.widget.LinearLayout
import android.view.WindowManager
import android.databinding.adapters.TextViewBindingAdapter.setTextSize
import android.graphics.Color.parseColor
import android.databinding.adapters.TextViewBindingAdapter.setText
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.provider.ContactsContract
import android.widget.TextView
import android.view.Gravity
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_calon.*
import kotlinx.android.synthetic.main.login_activity.*


class LoginActivity: AppCompatActivity() {
    var etNik : EditText? = null
    var btn : Button? = null
    var ilyt: TextInputLayout? = null
    internal lateinit var set: SharePref
    private var progres: ProgressBar? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        etNik = findViewById(R.id.inputNik)
        btn = findViewById(R.id.btnMasuk)
        progres = findViewById(R.id.progresbar) as ProgressBar


        set = SharePref(this)
        ilyt = findViewById(R.id.text_input_layout)
        val viewModel = ViewModelProviders.of(this).get(DataPemilihViewModel::class.java)
        btn!!.setOnClickListener {
            val login = etNik!!.text.toString()
            viewModel.dataPemilih!!.observeForever{
                xx ->
                for (data in xx!!){
                    val status = data.status_vote
                    val id = data.id
                    val nik = data.nik
                    if (login.equals(nik)){
                        if (status.equals("0")){
                            setProgressDialog()
                            Toast.makeText(this, "Welcome ${data.nama}", Toast.LENGTH_SHORT).show()
                            set.updateSetting(Const.PREF_MY_ID, id)
                            startActivity(Intent(this, ListCalonActivity::class.java))
                            ilyt!!.visibility = View.GONE
                            finish()
                        }else{
                            ilyt!!.error = "Anda Telah Melakukan vote"
                        }
                        break
                    }else{
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
    fun setProgressDialog() {

        val llPadding = 30
        val ll = LinearLayout(this)
        ll.orientation = LinearLayout.HORIZONTAL
        ll.setPadding(llPadding, llPadding, llPadding, llPadding)
        ll.gravity = Gravity.CENTER
        var llParam = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        llParam.gravity = Gravity.CENTER
        ll.layoutParams = llParam

        val progressBar = ProgressBar(this)
        progressBar.isIndeterminate = true
        progressBar.setPadding(0, 0, llPadding, 0)
        progressBar.layoutParams = llParam

        llParam = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        llParam.gravity = Gravity.CENTER
        val tvText = TextView(this)
        tvText.text = "Loading ..."
        tvText.setTextColor(resources.getColor(R.color.background))
        tvText.textSize = 20f
        tvText.layoutParams = llParam

        ll.addView(progressBar)
        ll.addView(tvText)

        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setView(ll)

        val dialog = builder.create()
        dialog.show()
        val window = dialog.window
        if (window != null) {
            val layoutParams = WindowManager.LayoutParams()
            layoutParams.copyFrom(dialog.window!!.attributes)
            layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT
            layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT
            dialog.window!!.attributes = layoutParams
        }
    }

}