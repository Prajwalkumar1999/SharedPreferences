package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)

        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        val button= findViewById<Button>(R.id.button)

        val sharedPreferences= getSharedPreferences("MyPrefs", MODE_PRIVATE)

        if(sharedPreferences.getBoolean("isLogged",false)) {

            val intent= Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {

            if(binding.editTextfullname.text.isEmpty()) {
                binding.editTextfullname.error ="Full name can't be empty"
            } else if (binding.editTextemail.text.isEmpty()) {
                binding.editTextemail.error="Email id can't be empty"
            } else if (binding.editTextpassword.text.isEmpty()) {
                binding.editTextpassword.error="Password can't be empty"
            } else {

                val editor = sharedPreferences.edit()
                editor.putString("fullName",binding.editTextfullname.text.toString())
                editor.putString("email",binding.editTextemail.text.toString())
                editor.putString("password",binding.editTextpassword.text.toString())
                editor.putBoolean("isLogged",true)
                editor.apply()


                val intent: Intent
                intent = Intent(this,HomeActivity::class.java)

                startActivity(intent)

            }
        }

        Log.d(TAG,"onCreate:Activity created")






    }
}