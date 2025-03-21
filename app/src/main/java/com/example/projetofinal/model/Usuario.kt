package com.example.projetofinal.model

class Usuario(private var nome: String, private var numero: String, private var senha: String) {
    constructor(numero: String, senha: String) : this("", numero, senha)

    private var id: Int = 0;

    fun getNome(): String {
        return nome
    }

    fun getNumero(): String {
        return numero
    }

    fun getSenha(): String {
        return senha
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


}