package com.tugas.evoting.service

import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.ArrayCompositeDisposable

abstract class ApiObserver<T> constructor(private val  compositeDisposable: CompositeDisposable): Observer<T> {
    override fun onComplete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSubscribe(d: Disposable) {
        compositeDisposable.add(d)
    }

    override fun onNext(t: T) {
        onApiSucces(t)
    }

    override fun onError(e: Throwable) {
        onApiError(e)
    }

    abstract fun onApiError(er: Throwable)

    abstract fun onApiSucces(data: T)
}