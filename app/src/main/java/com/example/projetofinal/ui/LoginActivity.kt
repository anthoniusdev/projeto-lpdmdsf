package com.example.projetofinal.ui

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.projetofinal.ApiService.ApiService
import com.example.projetofinal.ApiService.UsuarioResponse
import com.example.projetofinal.R
import com.example.projetofinal.model.Usuario
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = R.layout.login_screen
        setContentView(view)
        val btnLogin = findViewById<Button>(R.id.loginButton)
        val btnRegister = findViewById<LinearLayout>(R.id.btnRegister)
        btnLogin.setOnClickListener {
            val input_email = findViewById<EditText>(R.id.input_email_login)
            val input_password = findViewById<EditText>(R.id.input_password_login)
            if (input_email.text.toString().isEmpty() || input_password.text.toString().isEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Erro")
                    .setMessage("Por favor, preencha todos os campos.")
                    .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                    .show()
                return@setOnClickListener
            }
            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.136:3000/api/auth/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val apiService = retrofit.create(ApiService::class.java)
            val usuario = Usuario(input_email.text.toString(), input_password.text.toString())
            apiService.login(usuario).enqueue(object : retrofit2.Callback<UsuarioResponse> {
                override fun onResponse(
                    call: retrofit2.Call<UsuarioResponse>,
                    response: retrofit2.Response<UsuarioResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            val nome = responseBody.usuario.nome
                            val numero = responseBody.usuario.numero
                            val token = responseBody.token

                            val sharedPreferences =
                                getSharedPreferences("user_data", Context.MODE_PRIVATE)
                            val editor = sharedPreferences.edit()
                            editor.putString("nome", nome)
                            editor.putString("numero", numero)
                            editor.putString("token", token)
                            editor.apply()

                            // Agora que os dados estão salvos, você pode mudar de tela
                            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                            startActivity(intent)
                            finish()  // Fecha a LoginActivity
                        }
                    } else {
                        // Se a resposta não for bem-sucedida, exibe a mensagem de erro
                        Log.e("LoginActivity", "Erro na autenticação: ${response.message()}")
                    }
                }

                override fun onFailure(call: retrofit2.Call<UsuarioResponse>, t: Throwable) {
                    // Se der erro na requisição (ex: sem internet), exibe o erro
                    Log.e("LoginActivity", "Erro na requisição: ${t.message}")
                }
            })
        }
        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }


}