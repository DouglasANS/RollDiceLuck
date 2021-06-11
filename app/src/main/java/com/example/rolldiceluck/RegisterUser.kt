package com.example.rolldiceluck

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        val playerName = findViewById<EditText>(R.id.et_playerName)
        val button2 = findViewById<Button>(R.id.button2)

        button2.setOnClickListener{
            var player = playerName.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("playername", player)
            startActivity(intent)

        }
    }
}