package com.tugas.evoting.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataCalon {
    @SerializedName("id")
    lateinit var id: String

    @SerializedName("nama")
    lateinit var nama: String
    @SerializedName("email")
    lateinit var email: String
    @SerializedName("alamat")
    lateinit var alamat: String
    @SerializedName("foto")
    lateinit var foto: String
    @SerializedName("jenis_kelamin")
    lateinit var jenis_kelamin: String
    @SerializedName("nomor_telepon")
    lateinit var nomor_telepon: String
    @SerializedName("visi")
    lateinit var visi: String
    @SerializedName("misi")
    lateinit var misi: String
    @SerializedName("created_at")
    lateinit var created_at: String
    @SerializedName("updated_at")
    lateinit var updated_at: String

    constructor(){}

    constructor(nama: String, email:String, alamat: String, foto: String, jenis_kelamin: String, nomor_telepon: String, visi:String, misi: String, created_at: String, updated_at: String){
        this.nama = nama
        this.email = email
        this.alamat = alamat
        this.foto = foto
        this.jenis_kelamin = jenis_kelamin
        this.nomor_telepon = nomor_telepon
        this.visi = visi
        this.misi = misi
        this.created_at = created_at
        this.updated_at = updated_at
    }
}