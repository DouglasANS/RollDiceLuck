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
}
