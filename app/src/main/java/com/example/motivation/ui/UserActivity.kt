package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.infra.UserPreferences
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonSave.setOnClickListener(this)
        supportActionBar?.hide()
        isUserExists()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.button_save -> handleSave()
        }
    }

    private fun handleSave() {
        val userName = binding.editName.text.toString()
        if (userName != "") {
            UserPreferences(this).store(MotivationConstants.KEY.USER_NAME, userName)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, "O nome deve ser preenchido!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isUserExists() {
        val userName:String = UserPreferences(this).getData(MotivationConstants.KEY.USER_NAME)
        if(userName != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}