package com.example.projetofinal.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "funcionarios")
class Funcionario {
    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0;
    private var nome: String = "";
    private var numero: String = "";
    private var senha: String = "";
    private var cargo: String = "";

    fun getNome(): String {
        return nome
    }

    fun getNumero(): String {
        return numero
    }

    fun getSenha(): String {
        return senha
    }

    fun getCargo(): String {
        return cargo
    }

    fun getId(): Int {
        return id
    }

    fun setNome(nome: String) {
        this.nome = nome
    }

    fun setNumero(numero: String) {
        this.numero = numero
    }

    fun setSenha(senha: String) {
        this.senha = senha
    }

    fun setCargo(cargo: String) {
        this.cargo = cargo
    }

    fun setId(id: Int) {
        this.id = id
    }
}