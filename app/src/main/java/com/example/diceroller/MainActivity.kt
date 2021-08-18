package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Esta Activity permite ao usuário lançar um dado e ver o resultado
 * na tela
 */
class MainActivity : AppCompatActivity() {

    /**
     * Este método é chamado quando a Activity é criada.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encontre o botão no layout
        val rollButton: Button = findViewById(R.id.button)

        // Define um listener de cliques no botão para lançar os dados quando o usuário tocar no botão
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Lance os dados e atualize a tela com o resultado.
     */
    private fun rollDice() {
        // Crie um novo objeto de Dado com 6 lados e role-o
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Atualize a tela com o lançamento dos dados
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

/**
 * Dado com um número fixo de lados.
 */
class Dice(private val numSides: Int) {

    /**
     * Faça uma jogada de dados e retorne o resultado aleatória.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}