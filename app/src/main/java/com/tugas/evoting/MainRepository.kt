package com.tugas.evoting

import com.tugas.evoting.model.ResponseDataCalon
import com.tugas.evoting.service.ApiObserver
import com.tugas.evoting.service.ServiceFactory
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepository {
    private val apiService = ServiceFactory.create()
    private val compositeDisposable = CompositeDisposable()
    fun requestListCalon(onResult: (ResponseDataCalon)-> Unit, onError:(Throwable)->Unit){
        apiService.getCalon().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<ResponseDataCalon>(compositeDisposable){
                override fun onApiError(er: Throwable) {
                    onError(er)
                }

                override fun onApiSucces(data: ResponseDataCalon) {
                    onResult(data)
                }

            })
    }
    fun onDestroy(){
        compositeDisposable.clear()
    }
}