package com.example.projetofinal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.projetofinal.R
import com.example.projetofinal.database.ViewModel
import com.example.projetofinal.model.Funcionario
import com.example.projetofinal.ui.FuncionarioDialogFragment

class FuncionarioAdapter(
    private val context: Context,
    private var funcionarios: List<Funcionario>
) : BaseAdapter() {

    override fun getCount(): Int = funcionarios.size

    override fun getItem(position: Int): Funcionario = funcionarios[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_list, parent, false)

        val funcionario = getItem(position)

        // Configurar o nome do funcionário no TextView existente
        val tvNome = view.findViewById<TextView>(R.id.itemName)
        tvNome.text = funcionario.getNome()

        // Configurar os botões de editar e excluir
        val btnEditar = view.findViewById<ImageView>(R.id.editBtn) // Suponho que você tenha IDs para esses ImageViews
        val btnExcluir = view.findViewById<ImageView>(R.id.deleteBtn)

        btnEditar.setOnClickListener {
            // Implementar a edição do funcionário
            // Abrir o dialog de edição preenchendo com os dados do funcionário
            val dialog = FuncionarioDialogFragment.newInstance()
            dialog.setFuncionarioParaEditar(funcionario)
            dialog.show((context as AppCompatActivity).supportFragmentManager, "editar_funcionario")
        }

        btnExcluir.setOnClickListener {
            // Implementar a exclusão do funcionário
            // Pode adicionar um dialog de confirmação antes de excluir
            val viewModel = ViewModelProvider((context as AppCompatActivity))
                .get(ViewModel::class.java)
            viewModel.deletarFuncionario(funcionario)
        }

        return view
    }

    fun atualizarFuncionarios(novosFuncionarios: List<Funcionario>) {
        funcionarios = novosFuncionarios
        notifyDataSetChanged()
    }
}