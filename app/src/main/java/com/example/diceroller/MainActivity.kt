package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/** esta é a MainActivity, é a classe principal do app
 * e contém o método de criação do app
 * além de criar a var de ref do botão
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        //faz com que o dado role assim que o app é iniciado
        rollDice()
    }
    //Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show() criando um toast e exibindo ele na view
    /**Função rollDice() cria um objeto do tipo dado
     * chama a classe Dice
     * exibe a imagem adequada toda vez que o dado é jogado
     **/
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView2)

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()

        //criação do segundo dado
        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()
        val diceImage2: ImageView = findViewById(R.id.imageView3)

        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
        // Update the ImageView with the correct drawable resource ID
        diceImage2.setImageResource(drawableResource2)

        // Update the content description
        diceImage2.contentDescription = diceRoll2.toString()

    }
}

/** essa é a classe dice
 * ela da sentindo aos objetos desse tipo
 * criando seus atributos
 * **/
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}