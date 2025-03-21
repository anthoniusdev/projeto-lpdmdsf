package com.example.projetofinal.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.projetofinal.R
import com.example.projetofinal.model.Funcionario
import com.example.projetofinal.database.ViewModel
import com.google.android.material.textfield.TextInputEditText

class FuncionarioDialogFragment : DialogFragment() {

    private lateinit var funcionarioViewModel: ViewModel
    private var funcionarioParaEditar: Funcionario? = null
    private var modoEdicao = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.modal_add_funcionario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar ViewModel - Use o ViewModel específico de Funcionário
        funcionarioViewModel = ViewModelProvider(requireActivity()).get(ViewModel::class.java)

        // Configurar os botões
        val btnSalvar = view.findViewById<Button>(R.id.btnSalvar)
        val btnCancelar = view.findViewById<Button>(R.id.btnCancelar)

        // Campo de texto
        val etNome = view.findViewById<TextInputEditText>(R.id.etNome)
        val etNumero = view.findViewById<TextInputEditText>(R.id.etNumero)
        val etSenha = view.findViewById<TextInputEditText>(R.id.etSenha)
        val etCargo = view.findViewById<TextInputEditText>(R.id.etCargo)

        // Preencher campos se estiver em modo de edição
        if (modoEdicao && funcionarioParaEditar != null) {
            etNome.setText(funcionarioParaEditar!!.getNome())
            etNumero.setText(funcionarioParaEditar!!.getNumero())
            etSenha.setText(funcionarioParaEditar!!.getSenha())
            etCargo.setText(funcionarioParaEditar!!.getCargo())
        }

        btnCancelar.setOnClickListener {
            dismiss()
        }

        btnSalvar.setOnClickListener {
            val nome = etNome.text.toString().trim()
            val numero = etNumero.text.toString().trim()
            val senha = etSenha.text.toString().trim()
            val cargo = etCargo.text.toString().trim()

            if (validarCampos(nome, numero, senha, cargo)) {
                if (modoEdicao && funcionarioParaEditar != null) {
                    // Atualizar funcionário existente
                    funcionarioParaEditar!!.setNome(nome)
                    funcionarioParaEditar!!.setNumero(numero)
                    funcionarioParaEditar!!.setSenha(senha)
                    funcionarioParaEditar!!.setCargo(cargo)

                    funcionarioViewModel.atualizarFuncionario(funcionarioParaEditar!!)
                    Toast.makeText(context, "Funcionário atualizado com sucesso!", Toast.LENGTH_SHORT).show()
                } else {
                    // Criar um novo funcionário
                    val funcionario = Funcionario()
                    funcionario.setNome(nome)
                    funcionario.setNumero(numero)
                    funcionario.setSenha(senha)
                    funcionario.setCargo(cargo)

                    funcionarioViewModel.inserirFuncionario(funcionario)
                    Toast.makeText(context, "Funcionário adicionado com sucesso!", Toast.LENGTH_SHORT).show()
                }
                dismiss()
            }
        }
    }

    private fun validarCampos(nome: String, numero: String, senha: String, cargo: String): Boolean {
        if (nome.isEmpty() || numero.isEmpty() || senha.isEmpty() || cargo.isEmpty()) {
            Toast.makeText(context, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show()
            return false
        }

        if (senha.length < 6) {
            Toast.makeText(context, "A senha deve ter pelo menos 6 caracteres!", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    fun setFuncionarioParaEditar(funcionario: Funcionario) {
        this.funcionarioParaEditar = funcionario
        this.modoEdicao = true
    }

    override fun onStart() {
        super.onStart()
        // Configurar tamanho do diálogo
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    companion object {
        fun newInstance(): FuncionarioDialogFragment {
            return FuncionarioDialogFragment()
        }
    }
}