package com.example.projetofinal.ui

import android.animation.ObjectAnimator
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.animation.DecelerateInterpolator
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.projetofinal.R

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val progressText = findViewById<TextView>(R.id.progressText)

        progressBar.progress = 0

        val animator = ObjectAnimator.ofInt(progressBar, "progress", 0, 90)
        animator.duration = 2000
        animator.interpolator =
            DecelerateInterpolator()

        animator.addUpdateListener { animation ->
            val progress = animation.animatedValue as Int
            progressText.text = "$progress% do armazenamento utilizado"
        }

        animator.start()
        val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
        val token = sharedPreferences.getString("token", "")
//        val nome = sharedPreferences.getString("nome", "")
        val numero = sharedPreferences.getString("numero", "")
        val nome_view = findViewById<TextView>(R.id.nomePessoa)
//        nome_view.text = nome
//        val numero_view = findViewById<TextView>(R.id.
        val dashboard_button = findViewById<LinearLayout>(R.id.dashboard)
        val estoque_button = findViewById<LinearLayout>(R.id.estoque)
        val funcionarios_button = findViewById<LinearLayout>(R.id.funcionarios)
        val fornecedores_button = findViewById<LinearLayout>(R.id.fornecedores)
        val estatisticas_button = findViewById<LinearLayout>(R.id.estatisticas)
        val sobre_button = findViewById<LinearLayout>(R.id.sobre)
        dashboard_button.setOnClickListener {
            // Lógica para o botão Dashboard
            Log.d(TAG, "onCreate: Botão de Dashboard clicado")
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
        estoque_button.setOnClickListener {
            // Lógica para o botão Estoque
            Log.d(TAG, "onCreate: Botão de Estoque clicado")
            val intent = Intent(this, EstoqueActivity::class.java)
            startActivity(intent)
        }
        funcionarios_button.setOnClickListener {
            // Lógica para o botão Funcionários
            val intent = Intent(this, FuncionarioActivity::class.java)
            startActivity(intent)
        }
        fornecedores_button.setOnClickListener {
            // Lógica para o botão Fornecedores
        }
        estatisticas_button.setOnClickListener {
            // Lógica para o botão Estatísticas

        }
        sobre_button.setOnClickListener {
            // Lógica para o botão Sobre
        }

    }
}