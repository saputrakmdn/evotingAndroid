package com.tugas.evoting.model

import com.google.gson.annotations.SerializedName

class DataPemilih {

    @SerializedName("id")
    lateinit var id:String
    @SerializedName("nik")
    lateinit var nik: String
    @SerializedName("nama")
    lateinit var nama: String
    @SerializedName("jenis_kelamin")
    lateinit var jenis_kelamin: String
    @SerializedName("status_vote")
    lateinit var status_vote: String
    @SerializedName("created_at")
    lateinit var created_at: String
    @SerializedName("updated_at")
    lateinit var updated_at: String

    constructor(){}
    constructor(nik: String, nama: String, status_vote: String, created_at: String, updated_at: String){
        this.nik =  nik
        this.nama = nama
        this.status_vote = status_vote
        this.created_at = created_at
        this.updated_at = updated_at

    }
}