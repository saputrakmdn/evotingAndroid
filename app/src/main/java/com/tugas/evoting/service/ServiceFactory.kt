package com.tugas.evoting.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ServiceFactory {
    fun create(): ApiInterface{
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.addInterceptor(logging)
        val client = clientBuilder.build()
        val retrofit = Retrofit.Builder().baseUrl("http://172.16.10.12:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(client).build()
        return  retrofit.create(ApiInterface::class.java)
    }
}