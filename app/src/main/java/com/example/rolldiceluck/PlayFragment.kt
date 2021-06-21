package com.example.rolldiceluck

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.rolldiceluck.databinding.FragmentPlayBinding


class PlayFragment : Fragment() {
    private lateinit var binding: FragmentPlayBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayBinding.inflate(inflater, container, false)

        val imgDado1 = binding.imgDado1
        val imgDado2 = binding.imgDado2
        val button = binding.button
        val text = binding.welcomeMessage
        val shareButton = binding.share
        val textResult = binding.textResult
        val dado1Result = binding.resultDado1
        val dado2Result = binding.resultDado2

        val animGirar = AnimationUtils.loadAnimation(context, R.anim.anim)

        val namePlayer = "${arguments?.getString("Nomejogador")}"

        text.text = getString(R.string.welcome, namePlayer)

        val one = R.drawable.dice_1
        val two = R.drawable.dice_2
        val three = R.drawable.dice_3
        val four = R.drawable.dice_4
        val five = R.drawable.dice_5
        val six = R.drawable.dice_6

        var num1 = 0
        var num2 = 0
        var resultado = 0

        button.setOnClickListener {

            imgDado1.startAnimation(animGirar)
            imgDado2.startAnimation(animGirar)

            Handler().postDelayed({
                num1 = numAleatorio()
                num2 = numAleatorio()

                when(num1){
                    1 -> imgDado1.setImageResource(one)
                    2 -> imgDado1.setImageResource(two)
                    3 -> imgDado1.setImageResource(three)
                    4 -> imgDado1.setImageResource(four)
                    5 -> imgDado1.setImageResource(five)
                    6 -> imgDado1.setImageResource(six)
                }
                when(num2){
                    1 -> imgDado2.setImageResource(one)
                    2 -> imgDado2.setImageResource(two)
                    3 -> imgDado2.setImageResource(three)
                    4 -> imgDado2.setImageResource(four)
                    5 -> imgDado2.setImageResource(five)
                    6 -> imgDado2.setImageResource(six)
                }

                resultado = num1 + num2
                dado1Result.text = num1.toString()
                dado2Result.text = num2.toString()
                textResult.text = resultado.toString()

            }, 700)
        }

        shareButton.setOnClickListener{
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

        return binding.root
    }

    fun numAleatorio() : Int{
        return (1..6).random()
    }


}