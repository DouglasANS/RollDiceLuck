package com.example.rolldiceluck

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.rolldiceluck.databinding.FragmentPlayBinding
import com.example.rolldiceluck.databinding.FragmentRegisterUserBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class PlayFragment : Fragment() {
    private var binding: FragmentPlayBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayBinding.inflate(inflater, container, false)



        val imgDado1 = binding?.imgDado1
        val imgDado2 = binding?.imgDado2
        val button = binding?.button
        val text = binding?.welcomeMessage
        val shareButton = binding?.share

        val player = " Testando, ${arguments?.getString("Nomejogador")}?"

        val message = getString(R.string.welcome, player)

        text?.text = message

        val imagens = listOf(R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6)

        button?.setOnClickListener {
            imgDado1?.setImageResource(imagens.random())
            imgDado2?.setImageResource(imagens.random())
        }

        shareButton?.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "Você é sortudo!")
            intent.setPackage("com.whatsapp") /*Se não tiver zap vai dar crash, acha o id no googleplay*/
            intent.type = "text/plain"

            activity?.packageManager?.run {
                if (intent.resolveActivity(this) != null){
                    startActivity(intent)
                }else{
                    Toast.makeText(context, "Você não tem o app instalado", Toast.LENGTH_LONG).show()
                }
            } //

        }

        return binding?.root
    }

    private fun geraAleatorio(): Int{
        return (1..6).random()

    }

}