package com.example.motivation

import android.content.Context
import android.content.SharedPreferences

class UserPreferences(context: Context) {
    private val user: SharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE)

    fun store(key:String, str:String){
        user.edit().putString(key, str).apply()
    }

    fun getData(key:String):String{
        return user.getString(key, "") ?: ""
    }
}