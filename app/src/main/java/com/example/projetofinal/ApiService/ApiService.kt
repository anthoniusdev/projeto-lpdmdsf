package com.example.projetofinal.ApiService

import com.example.projetofinal.model.Fornecedor
import com.example.projetofinal.model.Funcionario
import com.example.projetofinal.model.Produto
import com.example.projetofinal.model.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {

    @GET("funcionarios")
    fun getFuncionarios(): Call<List<Funcionario>>

    @POST("funcionarios")
    fun postFuncionarios(
        @Body funcionario: Funcionario
    ): Call<Funcionario>

    @PUT("funcionarios")
    fun putFuncionarios(): Call<Funcionario>

    @DELETE("funcionarios/{id}")
    fun deleteFuncionarios(): Call<Funcionario>

    @GET("fornecedores")
    fun getFornecedores(): Call<List<Fornecedor>>

    @POST("fornecedores")
    fun postFornecedores(): Call<Fornecedor>

    @PUT("fornecedores")
    fun putFornecedores(): Call<Fornecedor>

    @DELETE("fornecedores/{id}")
    fun deleteFornecedores(): Call<Fornecedor>

    @GET("produtos")
    fun getProdutos(): Call<List<Produto>>

    @POST("produtos")
    fun postProdutos(): Call<Produto>

    @PUT("produtos")
    fun putProdutos(): Call<Produto>

    @DELETE("produtos/{id}")
    fun deleteProdutos(): Call<Produto>

    @POST("usuarios")
    fun postUsuarios(@Body usuario: Usuario): Call<Usuario>

    @POST("login")
    fun login(@Body usuario: Usuario): Call<UsuarioResponse>
}