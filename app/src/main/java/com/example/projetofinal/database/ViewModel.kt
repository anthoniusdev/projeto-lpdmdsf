package com.example.projetofinal.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.projetofinal.model.Funcionario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: FuncionarioRepository;
    val lerTodosOsFuncionarios: LiveData<List<Funcionario>>;

    init {
        val funcionarioDAO = AppDatabase.getDatabase(application).funcionarioDao()
        repository = FuncionarioRepository(funcionarioDAO)
        lerTodosOsFuncionarios = repository.lerTodosOsFuncionarios
    }
    fun inserirFuncionario(funcionario: Funcionario) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.inserirFuncionario(funcionario)
        }
    }

    fun atualizarFuncionario(funcionario: Funcionario) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.atualizarFuncionario(funcionario)
        }
    }

    fun deletarFuncionario(funcionario: Funcionario) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletarFuncionario(funcionario)
        }
    }
}