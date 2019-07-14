package com.tugas.evoting.data

import android.content.Context
import android.content.SharedPreferences

class SharePref {
    internal var mContext : Context
    private var sharePref: SharedPreferences
    constructor(context: Context){
        mContext = context
        sharePref = mContext.getSharedPreferences("nik", Context.MODE_PRIVATE)
    }
    fun readSetting(key: String):String{
       return sharePref.getString(key, "na")
    }
    fun updateSetting(key: String, value: String){
        val editor = sharePref.edit()
        editor.putString(key, value)
        editor.apply()
    }
    fun deleteAllSetting(){
        sharePref.edit().remove("nik").commit()
    }
}