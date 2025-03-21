package com.example.projetofinal.model

class Produto {

    private var id: Int = 0;
    private var nome: String = "";
    private var descricao: String = "";
    private var preco: Double = 0.0;
    private var categoria: String = "";
    private var quantidadeEmEstoque: Int = 0;
    private var fornecedor: Fornecedor = Fornecedor();


    fun getNome(): String {
        return nome
    }

    fun getPreco(): Double {
        return preco
    }

    fun getQuantidade(): Int {
        return quantidadeEmEstoque
    }

    fun getFornecedor(): Fornecedor {
        return fornecedor
    }

    fun getId(): Int {
        return id
    }

    fun setNome(nome: String) {
        this.nome = nome
    }

    fun setPreco(preco: Double) {
        this.preco = preco
    }

    fun setQuantidade(quantidade: Int) {
        this.quantidadeEmEstoque = quantidade
    }

    fun setFornecedor(fornecedor: Fornecedor) {
        this.fornecedor = fornecedor
    }

    fun setDescricao(descricao: String) {
        this.descricao = descricao
    }

    fun getDescricao(): String {
        return descricao
    }

    fun setCategoria(categoria: String) {
        this.categoria = categoria
    }

    fun getCategoria(): String {
        return categoria
    }
}