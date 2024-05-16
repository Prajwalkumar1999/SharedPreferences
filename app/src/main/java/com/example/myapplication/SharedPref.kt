package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class SharedPref : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)

        val sharedPreferences= getSharedPreferences("MyPrefs", MODE_PRIVATE)

        val editor= sharedPreferences.edit()
        editor.putString("key","value")
        editor.putBoolean("isLogged",true)
        editor.putString("keyToRemove","This is the example tgo remove data")
        editor.apply()


        val value = sharedPreferences.getString("key","defaultValue")
        val isLogged = sharedPreferences.getBoolean("isLogged",false)

        Log.d("shared Preference Values", value.toString())


        editor.remove("keyToRemove")
        editor.apply()

    }
}