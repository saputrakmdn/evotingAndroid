package com.tugas.evoting.service

import com.tugas.evoting.model.ResponseDataCalon
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {
    @GET("datacalon")
    fun getCalon():Observable<ResponseDataCalon>

}