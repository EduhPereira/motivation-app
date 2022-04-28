package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.infra.UserPreferences
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.textHelloUser.text = "Olá, ${UserPreferences(this).getData(MotivationConstants.KEY.USER_NAME)}!"
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