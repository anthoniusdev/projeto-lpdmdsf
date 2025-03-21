package com.example.projetofinal.model

class Fornecedor {
    private var id: Int = 0;
    private var nome: String = "";
    private var cnpj: String = "";
    private var telefone: String = "";

    fun getNome(): String {
        return nome
    }

    fun getCnpj(): String {
        return cnpj
    }

    fun getTelefone(): String {
        return telefone
    }

    fun getId(): Int {
        return id
    }

    fun setNome(nome: String) {
        this.nome = nome
    }

    fun setCnpj(cnpj: String) {
        this.cnpj = cnpj
    }

    fun setTelefone(telefone: String) {
        this.telefone = telefone
    }

    fun setId(id: Int) {
        this.id = id
    }
}