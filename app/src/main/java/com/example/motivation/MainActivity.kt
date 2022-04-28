package com.example.motivation

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.textHelloUser.text = "Olá, ${UserPreferences(this).getData("USER_NAME")}!"
        setContentView(binding.root)

        supportActionBar?.hide()
        binding.buttonNewPhrase.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.button_new_phrase -> return
        }
    }
}