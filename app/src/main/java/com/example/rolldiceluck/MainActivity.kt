package com.example.rolldiceluck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dado1 = findViewById<TextView>(R.id.dado1);
        val dado2 = findViewById<TextView>(R.id.dado2);
        val button = findViewById<Button>(R.id.button);



        button.setOnClickListener {
            dado1.text = geraAleatorio().toString();
            dado2.text = geraAleatorio().toString();
        }


    }

    private fun geraAleatorio(): Int{
        return (1..6).random()

    }
}