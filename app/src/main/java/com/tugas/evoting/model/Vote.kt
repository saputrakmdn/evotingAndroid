package com.tugas.evoting.model

import com.google.gson.annotations.SerializedName

class Vote {
    @SerializedName("id")
    lateinit var id: String
    @SerializedName("id_calon")
    lateinit var id_calon: String
    @SerializedName("id_pemilih")
    lateinit var id_pemilih: String
    @SerializedName("created_at")
    lateinit var created_at: String
    @SerializedName("updated_at")
    lateinit var updated_at: String
    constructor(){}
    constructor(id: String, id_calon: String, id_pemilih: String){
        this.id = id
        this.id_calon = id_calon
        this.id_pemilih = id_pemilih
    }
}