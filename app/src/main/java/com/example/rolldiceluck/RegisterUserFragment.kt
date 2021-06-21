package com.example.rolldiceluck

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.rolldiceluck.databinding.FragmentRegisterUserBinding

class RegisterUserFragment : Fragment() {
    private lateinit var binding: FragmentRegisterUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterUserBinding.inflate(inflater, container, false)

        val playerName = binding.etPlayerName
        val button2 = binding.button2

        button2.setOnClickListener{
            val player = playerName.text.toString()

            if ( playerName.text.toString() == "" ){
                Toast.makeText(context, "Escreva um nome", Toast.LENGTH_LONG ).show()

            }else{
                findNavController().navigate(R.id.action_registerUserFragment_to_playFragment, bundleOf("Nomejogador" to player))
            }

        }

        return binding.root
    }




}