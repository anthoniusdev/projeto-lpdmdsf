package com.example.projetofinal.database

import androidx.lifecycle.LiveData
import com.example.projetofinal.database.DAO.FuncionarioDAO
import com.example.projetofinal.model.Funcionario
import com.example.projetofinal.model.Usuario

class FuncionarioRepository(private val funcionarioDao: FuncionarioDAO)  {
    val lerTodosOsFuncionarios: LiveData<List<Funcionario>> = funcionarioDao.getAll()

    suspend fun inserirFuncionario(funcionario: Funcionario) {
        funcionarioDao.create(funcionario)
    }

    suspend fun atualizarFuncionario(funcionario: Funcionario) {
        funcionarioDao.update(funcionario)
    }

    suspend fun deletarFuncionario(funcionario: Funcionario) {
        funcionarioDao.delete(funcionario)
    }

    suspend fun buscarFuncionarioPorId(id: Int): Funcionario? {
        return funcionarioDao.getById(id)
    }

}