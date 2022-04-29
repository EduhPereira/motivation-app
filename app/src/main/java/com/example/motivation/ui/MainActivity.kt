package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
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
        binding.imageAllInclusive.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
        binding.buttonNewPhrase.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.image_happy, R.id.image_sunny, R.id.image_all_inclusive  -> handleMenuClick(view.id)
            R.id.button_new_phrase -> return
        }
    }

    private fun handleMenuClick(id: Int) {
        if(id == R.id.image_all_inclusive){
            binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.white))
            binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.black))
            binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.black))
        }
        if(id == R.id.image_happy){
            binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.black))
            binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
            binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.black))
        }
        if(id == R.id.image_sunny){
            binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.black))
            binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.black))
            binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
        }
    }

}