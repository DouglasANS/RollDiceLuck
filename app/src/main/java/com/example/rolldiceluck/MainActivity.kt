package com.example.rolldiceluck

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgDado1 = findViewById<ImageView>(R.id.imgDado1)
        val imgDado2 = findViewById<ImageView>(R.id.imgDado2)
        val button = findViewById<Button>(R.id.button);
        val text = findViewById<TextView>(R.id.welcomeMessage)
        val shareButton = findViewById<FloatingActionButton>(R.id.share)

        val player = intent.getStringExtra("playername")

        val message = getString(R.string.welcome, player)

        text.text = message

        val imagens = listOf(R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6)

        button.setOnClickListener {
            imgDado1.setImageResource(imagens.random())
            imgDado2.setImageResource(imagens.random())
        }

        shareButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "Você é sortudo!")
            intent.setPackage("com.whatsapp") /*Se não tiver zap vai dar crash, acha o id no googleplay*/
            intent.type = "text/plain"


            if(intent.resolveActivity(this.packageManager) != null){
                startActivity(intent)
            }else{
                Toast.makeText(this, "Você não tem o app instalado", Toast.LENGTH_LONG).show()
                /*startActivity(parametro da loja caso não tenha o app no cell)*/
                /*O zap tem que ter um Send no androidmanifest pra receber o texto, torcer pra que tenha*/
            }


        }


    }

    override fun onStart() {
        super.onStart()
        Log.i("Ciclo de vida", "on Start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Ciclo de vida", "on Resume")

    }

    override fun onPause() {
        super.onPause()
        Log.i("Ciclo de vida", "on Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Ciclo de vida", "on Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Ciclo de vida", "on Destroy")
    }


    private fun geraAleatorio(): Int{
        return (1..6).random()

    }
}