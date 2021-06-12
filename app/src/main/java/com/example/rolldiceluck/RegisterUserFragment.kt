package com.example.rolldiceluck

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.rolldiceluck.databinding.FragmentRegisterUserBinding


class RegisterUserFragment : Fragment() {
    private var binding: FragmentRegisterUserBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterUserBinding.inflate(inflater, container, false)

        val playerName = binding?.etPlayerName
        val button2 = binding?.button2

        button2?.setOnClickListener{
            var player = playerName?.text.toString()
        }



        /*button2.setOnClickListener{
            var player = playerName.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("playername", player)
            startActivity(intent)*/

        return binding?.root
    }




}