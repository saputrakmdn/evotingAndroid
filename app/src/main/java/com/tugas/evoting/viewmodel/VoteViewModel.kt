package com.tugas.evoting.viewmodel

import android.arch.lifecycle.ViewModel
import com.tugas.evoting.model.Vote
import com.tugas.evoting.service.ApiOnly
import com.tugas.evoting.service.Const
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VoteViewModel: ViewModel() {
    var retrofit : Retrofit? = null
    fun postVote(): Retrofit?{
        if (retrofit == null){
            retrofit = Retrofit.Builder().baseUrl(Const.base_url).addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }

}