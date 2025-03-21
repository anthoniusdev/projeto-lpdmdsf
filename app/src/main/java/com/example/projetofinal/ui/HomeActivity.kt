package com.example.projetofinal.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.projetofinal.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)
        val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
        val token = sharedPreferences.getString("token", "")
        val nome = sharedPreferences.getString("nome", "")
        val numero = sharedPreferences.getString("numero", "")
        val nome_view = findViewById<TextView>(R.id.nomePessoa)
        nome_view.text = nome
        val numero_view = findViewById<TextView>(R.id.)

    }
}