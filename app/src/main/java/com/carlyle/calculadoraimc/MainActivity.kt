package com.carlyle.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carlyle.calculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btCalcular = binding.btCalcular
        val mensagem = binding.txtMensagem

        btCalcular.setOnClickListener {
            val editPeso = binding.editPeso.text.toString()
            val editAltura = binding.editAltura.text.toString()

            if (editPeso.isEmpty()) {
                mensagem.setText("Informe seu peso")
            } else if (editAltura.isEmpty()) {
                mensagem.setText("Informe sua altura")
            } else {
                CalculoIMC()
            }
        }
    }

    private fun CalculoIMC() {
        val pesoID = binding.editPeso
        val alturaID = binding.editAltura
        val resultado = binding.txtMensagem

        val peso = Integer.parseInt(pesoID.text.toString())
        val altura = java.lang.Float.parseFloat(alturaID.text.toString())

        val imc = peso / (altura * altura)

        val mensagem = when {
            imc <= 18.5 -> "Peso Baixo"
            imc <= 24.9 -> "Peso Normal"
            imc <= 29.9 -> "Sobrepreso"
            imc <= 34.9 -> "Obesidade (GRAU I)"
            imc <= 39.9 -> "Obesidade (GRAU II)"
            else -> "Obsesidade morbida"
        }

        imc.toString()
        resultado.setText("IMC: $imc \n $mensagem")
    }
}