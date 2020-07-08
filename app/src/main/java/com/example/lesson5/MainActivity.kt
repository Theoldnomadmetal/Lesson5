package com.example.lesson5

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast



class MainActivity : AppCompatActivity() {

    var loginMain:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginmain = findViewById<EditText>(R.id.etlogin)
        val passwordmain = findViewById<EditText>(R.id.etpassword)
        val btnEnter = findViewById<Button>(R.id.button_login)
        val btnRegister = findViewById<Button>(R.id.button_reg)

        val profilePreference = getSharedPreferences("profPref", Context.MODE_PRIVATE)
        val passwordPreference = getSharedPreferences("passPref",Context.MODE_PRIVATE)



        btnRegister.setOnClickListener {
            val profText = loginmain.text.toString()
            val passProfText = passwordmain.text.toString()

            profilePreference.edit().putString("profPref",profText).apply()
            passwordPreference.edit().putString("passPref",passProfText).apply()

            Toast.makeText(applicationContext,"Вы зарегистрированы",Toast.LENGTH_LONG).show()
        }
        btnEnter.setOnClickListener {
            val compareProfile = loginmain.text.toString()
            val comparePassword = passwordmain.text.toString()

            val passFromPreference = passwordPreference.getString("passPref","Нет данных")
            val textfromPreference = profilePreference.getString("profPref", "Нет данных")
            if (compareProfile == textfromPreference && comparePassword == passFromPreference){
                val intent = Intent(this, SecondActivity::class.java)


                startActivity(intent)

            }else Toast.makeText(applicationContext,"Данные не найдены",Toast.LENGTH_LONG).show()







        }
    }

    override fun onStop() {
        super.onStop()


    }
}