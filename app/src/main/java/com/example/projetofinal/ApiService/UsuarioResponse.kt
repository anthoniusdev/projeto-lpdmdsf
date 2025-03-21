package com.example.projetofinal.ApiService

data class UsuarioResponse(
    val mensagem: String,
    val usuario: Usuario,
    val token: String
)

data class Usuario(
    val nome: String,
    val numero: String,
    val senha: String
)