package com.example.projetofinal.ui

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.projetofinal.ApiService.ApiService
import com.example.projetofinal.R
import com.example.projetofinal.model.Usuario
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_screen)
        val phone_input = findViewById<EditText>(R.id.phone_input)
        val name_input = findViewById<EditText>(R.id.name_input)
        val password_input = findViewById<EditText>(R.id.password_input)
        val confirm_password_input = findViewById<EditText>(R.id.password_confirm_input)
        val btnRegister = findViewById<Button>(R.id.registerButton)
        btnRegister.setOnClickListener {
            if (phone_input.text.toString().isEmpty() || name_input.text.toString()
                    .isEmpty() || password_input.text.toString()
                    .isEmpty() || confirm_password_input.text.toString().isEmpty()
            ) {
                AlertDialog.Builder(this)
                    .setTitle("Erro")
                    .setMessage("Por favor, preencha todos os campos.")
                    .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                    .show()
                return@setOnClickListener
            }
            if (password_input.text.toString() != confirm_password_input.text.toString()) {
                AlertDialog.Builder(this)
                    .setTitle("Erro")
                    .setMessage("As senhas não coincidem.")
                    .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                    .show()
                return@setOnClickListener
            }
            setContentView(R.layout.confirm_register_screen)
            val btnConfirm = findViewById<Button>(R.id.btnConfirmRegister)
            btnConfirm.setOnClickListener {
                val input_codigo_confirmacao = findViewById<EditText>(R.id.input_codigo_confirmacao)
                if (input_codigo_confirmacao.text.toString()
                        .isEmpty() || input_codigo_confirmacao.text.toString() != "2025"
                ) {
                    AlertDialog.Builder(this)
                        .setTitle("Erro")
                        .setMessage("Por favor, insira o código corretamente.")
                        .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                        .show()

                } else {
                    setContentView(R.layout.alert_after_registraton_screen)
                    val btnEmpresa = findViewById<Button>(R.id.btnEmpresa)
                    val btnFuncionario = findViewById<Button>(R.id.btnFuncionario)
                    btnFuncionario.setOnClickListener() {
                        editScreen()
                    }
                    btnEmpresa.setOnClickListener() {
                        editScreen()

                    }
                }

            }
//            val usuario = Usuario(
//                name_input.text.toString(),
//                phone_input.text.toString(),
//                password_input.text.toString()
//            )
//            val retrofit = Retrofit.Builder()
//                .baseUrl("http://192.168.62.249:3000/api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//            val apiService = retrofit.create(ApiService::class.java)
//            apiService.postUsuarios(usuario).enqueue(object : retrofit2.Callback<Usuario> {
//                override fun onResponse(
//                    call: retrofit2.Call<Usuario>,
//                    response: retrofit2.Response<Usuario>
//                ) {
//                    if (response.isSuccessful) {
//                        AlertDialog.Builder(this@RegisterActivity)
//                            .setTitle("Sucesso")
//                            .setMessage("Usuário cadastrado com sucesso.")
//                            .setPositiveButton("OK") { dialog, _ ->
//                                dialog.dismiss()
//                                val intent =
//                                    Intent(this@RegisterActivity, LoginActivity::class.java)
//                                startActivity(intent)
//                            }
//                            .show()
//
//
//                    } else {
//                        Log.d(TAG, "onResponse: ${response.errorBody()?.string()}")
//                        AlertDialog.Builder(this@RegisterActivity)
//                            .setTitle("Erro")
//                            .setMessage("Erro ao cadastrar usuário.")
//                            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
//                            .show()
//                    }
//                }
//
//                override fun onFailure(call: retrofit2.Call<Usuario>, t: Throwable) {
//                    Log.d(TAG, "onFailure: $t")
//                    AlertDialog.Builder(this@RegisterActivity)
//                        .setTitle("Erro")
//                        .setMessage("Erro ao cadastrar usuário.")
//                        .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
//                        .show()
//                }
//            })


        }
    }

    fun editScreen() {
        setContentView(R.layout.edit_perfil_screen)
        val editNome = findViewById<EditText>(R.id.editNome)
        val editCodigoEmpresa = findViewById<EditText>(R.id.editCodigoEmpresa)
        val btnFinish = findViewById<Button>(R.id.button_finish)
        btnFinish.setOnClickListener() {
            if (editNome.text.toString().isEmpty() || editCodigoEmpresa.text.toString().isEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle("Erro")
                    .setMessage("Por favor, preencha todos os campos.")
                    .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                    .show()
            } else {
                setContentView(R.layout.finished_register_screen)
                val btnFinishRegister = findViewById<Button>(R.id.finishedRegisterButton)
                btnFinishRegister.setOnClickListener() {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}