package com.tugas.evoting.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.tugas.evoting.model.DataPemilih
import com.tugas.evoting.service.ApiOnly
import com.tugas.evoting.service.Const
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataPemilihViewModel: ViewModel() {
    var lisPemilih: MutableLiveData<List<DataPemilih>>? = null
    val dataPemilih: LiveData<List<DataPemilih>>
    get() {
        if (lisPemilih == null){
            lisPemilih = MutableLiveData()
            loadDataPemilih()
        }
        return lisPemilih!!
    }

    private fun loadDataPemilih() {
        val retrofit =  Retrofit.Builder().baseUrl(Const.base_url).addConverterFactory(GsonConverterFactory.create()).build()
        val apiData = retrofit.create(ApiOnly::class.java)
        val getData = apiData.getDataPemilih()
        getData.enqueue(object : Callback<List<DataPemilih>>{
            override fun onFailure(call: Call<List<DataPemilih>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<DataPemilih>>, response: Response<List<DataPemilih>>) {
                lisPemilih!!.value = response.body()
            }

        })
    }
}