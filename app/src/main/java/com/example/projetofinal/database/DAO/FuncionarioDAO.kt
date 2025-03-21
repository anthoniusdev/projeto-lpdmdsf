package com.example.projetofinal.database.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.projetofinal.model.Funcionario

@Dao
interface FuncionarioDAO {
    @Insert
    suspend fun create(funcionario: Funcionario)

    @Update
    suspend fun update(funcionario: Funcionario)

    @Query("SELECT * FROM funcionarios WHERE id = :id")
    suspend fun getById(id: Int): Funcionario?

    @Query("SELECT * FROM funcionarios")
    fun getAll(): LiveData<List<Funcionario>>

    @Delete
    suspend fun delete(funcionario: Funcionario)
}