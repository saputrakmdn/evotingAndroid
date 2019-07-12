package com.tugas.evoting.service

import com.tugas.evoting.model.DataCalon
import retrofit2.Call
import retrofit2.http.GET

interface ApiOnly {
    @GET("datacalon")
    fun getDataCalon() :  Call<List<DataCalon>>
}