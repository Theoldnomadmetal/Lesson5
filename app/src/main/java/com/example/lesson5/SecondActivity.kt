package com.example.lesson5

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val loginProfile = findViewById<EditText>(R.id.etprofile_login)
        val loginPassword = findViewById<EditText>(R.id.etprofile_password)
        val buttonRefresh = findViewById<Button>(R.id.button_refresh)
        val buttonExit = findViewById<Button>(R.id.button_exit)


        val loginText = loginProfile.text.toString()
        val passwordText = loginPassword.text.toString()

        val profilePreference = getSharedPreferences("profPref", Context.MODE_PRIVATE)
        val passwordPreference = getSharedPreferences("passPref",Context.MODE_PRIVATE)

        buttonRefresh.setOnClickListener {
            profilePreference.edit().putString("profPref",loginText).apply()
            passwordPreference.edit().putString("passPref", passwordText).apply()

            Toast.makeText(applicationContext,"Данные обновлены",Toast.LENGTH_LONG).show()

        }
        buttonExit.setOnClickListener {
            profilePreference.edit().putString("profPref",loginText).clear()
            passwordPreference.edit().putString("passPref", passwordText).clear()
            Toast.makeText(applicationContext,"Данные очищены",Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }





































































    }
}







