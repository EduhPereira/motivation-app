package com.example.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class CategoryPreferences(context: Context) {
    private val category: SharedPreferences = context.getSharedPreferences("Category", Context.MODE_PRIVATE)

    fun store(string: String, key: String){
        category.edit().putString(key, string).apply()
    }

    fun getData(key: String):String{
        return category.getString(key, "") ?: ""
    }
}