package com.tugas.evoting.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseDataCalon (
    @SerializedName("status_code")@Expose var StatusCode: Int,
    @SerializedName("data")@Expose var data: MutableList<DataCalon>
){
    data class DataCalon(
        @SerializedName("id")@Expose var id: Int,
        @SerializedName("nama")@Expose var nama: String,
        @SerializedName("email")@Expose var email: String,
        @SerializedName("alamat")@Expose var alamat: String,
        @SerializedName("foto")@Expose var foto: String,
        @SerializedName("jenis_kelamin")@Expose var jenis_kelamin: String,
        @SerializedName("nomor_telepon")@Expose var nomor_telepon: String,
        @SerializedName("created_at")@Expose var created_at: String,
        @SerializedName("updated_at")@Expose var updated_at: String

    )
}