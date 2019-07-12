package com.tugas.evoting.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.tugas.evoting.MainRepository
import com.tugas.evoting.model.ResponseDataCalon

class CalonViewModel(application: Application): AndroidViewModel(application) {
    private val repository = MainRepository()
    var listCalon: MutableLiveData<ResponseDataCalon> = MutableLiveData()
    var error: MutableLiveData<Throwable> = MutableLiveData()
    fun getListCalon(){
        repository.requestListCalon({
            listCalon.postValue(it)
            Log.w("TAG", "TES $listCalon")
        },{
            error.postValue(it)
        })
    }

    override fun onCleared() {
        super.onCleared()
        repository.onDestroy()
    }
}