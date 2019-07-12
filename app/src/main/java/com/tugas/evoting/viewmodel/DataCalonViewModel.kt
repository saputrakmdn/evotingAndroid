package com.tugas.evoting.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.tugas.evoting.model.DataCalon
import com.tugas.evoting.service.ApiOnly
import com.tugas.evoting.service.Const
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataCalonViewModel: ViewModel() {
    var listCalon : MutableLiveData<List<DataCalon>>? = null
    val dataCalon : LiveData<List<DataCalon>>
    get() {
        if (listCalon == null){
            listCalon = MutableLiveData()
            loadDataCalon()
        }
        return listCalon!!
    }

    fun loadDataCalon() {
       val retrofit =  Retrofit.Builder().baseUrl(Const.base_url).addConverterFactory(GsonConverterFactory.create()).build()
        val apiData = retrofit.create(ApiOnly::class.java)
        val getData = apiData.getDataCalon()
        getData.enqueue(object : Callback<List<DataCalon>>{
            override fun onFailure(call: Call<List<DataCalon>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<DataCalon>>, response: Response<List<DataCalon>>) {
                listCalon!!.value = response.body()
            }

        })
    }
}