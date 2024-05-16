package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_home)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)

        val sharedPreferences= getSharedPreferences("MyPrefs", MODE_PRIVATE)

        binding.textViewFullNameValue.text= sharedPreferences.getString("fullName","defaultValue")
        binding.textViewEmailValue.text= sharedPreferences.getString("email","defaultValue")
        binding.textViewPasswordValue.text= sharedPreferences.getString("password","defaultValue")

        binding.button1.setOnClickListener {

            logout(sharedPreferences)
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun logout(sharedPreferences:SharedPreferences) {
        val editor =sharedPreferences.edit()
        editor.clear()
        editor.apply()

    }
}