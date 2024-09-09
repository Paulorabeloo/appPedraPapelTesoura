package com.example.apppedrapapeltesoura

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun selecionaPedra(view: View) {
        opcaoSelecionada("pedra")
    }

    fun selecionaPapel(view: View) {
        opcaoSelecionada("papel")
    }

    fun selecionaTesoura(view: View) {
        opcaoSelecionada("tesoura")
    }

    fun selecionaSpock(view: View) {
        opcaoSelecionada("spock")
    }

    fun selecionaLagarto(view: View) {
        opcaoSelecionada("lagarto")
    }

    private fun opcaoSelecionada(escolhaUsuario: String) {
        val imagemResultado = findViewById<ImageView>(R.id.imagemResultado)
        val textoResultado = findViewById<TextView>(R.id.textoResultado)

        val opcoes = arrayOf("pedra", "tesoura", "papel", "spock", "lagarto")
        val escolhaApp = opcoes[Random.nextInt(opcoes.size)]

        when (escolhaApp) {
            "pedra" -> imagemResultado.setImageResource(R.drawable.maopedra)
            "tesoura" -> imagemResultado.setImageResource(R.drawable.mao2dedo)
            "papel" -> imagemResultado.setImageResource(R.drawable.maopapel)
            "spock" -> imagemResultado.setImageResource(R.drawable.maozinha)
            "lagarto" -> imagemResultado.setImageResource(R.drawable.maoburaco)
        }

        when {
            escolhaApp == "tesoura" && escolhaUsuario == "papel"
                    || escolhaApp == "papel" && escolhaUsuario == "pedra"
                    || escolhaApp == "pedra" && escolhaUsuario == "tesoura"
                    || escolhaApp == "spock" && escolhaUsuario == "pedra"
                    || escolhaApp == "pedra" && escolhaUsuario == "spock"
                    || escolhaApp == "lagarto" && escolhaUsuario == "spock"
                    || escolhaApp == "spock" && escolhaUsuario == "lagarto"
                    || escolhaApp == "tesoura" && escolhaUsuario == "lagarto"
                    || escolhaApp == "lagarto" && escolhaUsuario == "tesoura"
                    || escolhaApp == "papel" && escolhaUsuario == "lagarto"
                    || escolhaApp == "lagarto" && escolhaUsuario == "papel"
            -> textoResultado.text = "Você Perdeu =("

            escolhaUsuario == "tesoura" && escolhaApp == "papel"
                    || escolhaUsuario == "papel" && escolhaApp == "pedra"
                    || escolhaUsuario == "pedra" && escolhaApp == "tesoura"
                    || escolhaUsuario == "spock" && escolhaApp == "pedra"
                    || escolhaUsuario == "pedra" && escolhaApp == "spock"
                    || escolhaUsuario == "lagarto" && escolhaApp == "spock"
                    || escolhaUsuario == "spock" && escolhaApp == "lagarto"
                    || escolhaUsuario == "tesoura" && escolhaApp == "lagarto"
                    || escolhaUsuario == "lagarto" && escolhaApp == "tesoura"
                    || escolhaUsuario == "papel" && escolhaApp == "lagarto"
                    || escolhaUsuario == "lagarto" && escolhaApp == "papel"
            -> textoResultado.text = "Você Ganhou =)";

            else -> textoResultado.text = "Empate!!"
        }
    }
}
