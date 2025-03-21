package com.example.projetofinal.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.projetofinal.FuncionarioAdapter
import com.example.projetofinal.R
import com.example.projetofinal.database.ViewModel

class FuncionarioActivity : AppCompatActivity() {

    private lateinit var funcionarioViewModel: ViewModel
    private lateinit var listView: ListView
    private lateinit var adapter: FuncionarioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.funcionarios_screen)

        // Inicializar ViewModel
        funcionarioViewModel = ViewModelProvider(this).get(ViewModel::class.java)

        // Configurar ListView
        listView = findViewById(R.id.listViewFuncionários)
        adapter = FuncionarioAdapter(this, ArrayList())
        listView.adapter = adapter

        // Observar mudanças na lista de funcionários
        funcionarioViewModel.lerTodosOsFuncionarios.observe(this, Observer { funcionarios ->
            funcionarios?.let {
                adapter.atualizarFuncionarios(it)
            }
        })

        // Botão para adicionar funcionário
        val btnAdicionar = findViewById<ImageView>(R.id.addButtonFuncionários)
        btnAdicionar.setOnClickListener {
            val dialogFragment = FuncionarioDialogFragment.newInstance()
            dialogFragment.show(supportFragmentManager, "funcionario_dialog")
        }
    }
}