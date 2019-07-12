package com.tugas.evoting.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.util.Log
import com.tugas.evoting.model.ResponseDataCalon

class ItemCalonViewModel(model: ResponseDataCalon.DataCalon): ViewModel() {
    var nama: ObservableField<String> = ObservableField()
    var foto: ObservableField<String> = ObservableField()
    init {
        nama.set(model.nama)
        foto.set(model.foto)

    }
}