package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.data.Mock
import com.example.motivation.infra.UserPreferences
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var category: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.textHelloUser.text = "Olá, ${UserPreferences(this).getData(MotivationConstants.KEY.USER_NAME)}!"
        handleNewPhrase(this.category)

        binding.imageAllInclusive.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
        binding.buttonNewPhrase.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.image_happy, R.id.image_sunny, R.id.image_all_inclusive  -> handleMenuClick(view.id)
            R.id.button_new_phrase -> handleNewPhrase(category)
        }
    }

    private fun handleMenuClick(id: Int) {
        binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.black))


        if(id == R.id.image_all_inclusive){
            binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.white))
            category = MotivationConstants.CATEGORY.ALL_INCLUSIVE
        }
        if(id == R.id.image_happy){
            binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
            category = MotivationConstants.CATEGORY.HAPPY
        }
        if(id == R.id.image_sunny){
            binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
            category = MotivationConstants.CATEGORY.SUNNY
        }
    }

    private fun handleNewPhrase(category: Int) {
        binding.textPhrase.text = Mock().getPhrase(category)
    }

}