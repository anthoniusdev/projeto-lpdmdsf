package com.example.projetofinal.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.projetofinal.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)


//        val fornecedoresAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, fornecedoresList)
//        listViewFornecedores.adapter = fornecedoresAdapter
//        imgFornecedores.setOnClickListener {
//            mostrarModal(R.layout.fornecedores_screen)
//            Log.d("MainActivity", "Imagem clicada")
//
//        }
        // Se quiser começar com ela expandida:
//        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        // Você pode escutar mudanças:
//        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
//            override fun onStateChanged(bottomSheet: View, newState: Int) {
//                // Aqui você pode reagir a estados como EXPANDED, COLLAPSED, etc
//            }
//
//            override fun onSlide(bottomSheet: View, slideOffset: Float) {
//                // Aqui você pode animar algo conforme o usuário arrasta
//            }
//        })

//        progressBar = findViewById(R.id.progressBar)
//        progressText = findViewById(R.id.progressText)
//        button = findViewById(R.id.button_finish)

        // Criar o canal de notificação
//        createNotificationChannel()

//        // Verificar e solicitar permissão para notificações (Android 13+)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 1)
//            }
//        }
//
//        button.setOnClickListener {
//            enviarNotificacao()
//            mostrarModal()
//        }
        // Simula um carregamento aumentando o progresso
//        Thread {
//            while (progressStatus < 75) { // Simula 75% do armazenamento
//                progressStatus += 5
//                handler.post {
//                    progressBar.progress = progressStatus
//                    progressText.text = "$progressStatus% do armazenamento utilizado"
//                }
//                Thread.sleep(500)
//            }
//        }.start()
//    }
        // Cria o canal de notificação (necessário para Android 8.0+)
//    private fun createNotificationChannel() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val channel = NotificationChannel(
//                "meu_canal_id",   // ID do canal
//                "Nome do Canal",   // Nome do canal
//                NotificationManager.IMPORTANCE_DEFAULT // Importância da notificação
//            ).apply {
//                description = "Descrição do canal de notificações"
//            }
//
//            val manager = getSystemService(NotificationManager::class.java)
//            manager?.createNotificationChannel(channel)
//        }
//    }

        // Função para enviar a notificação
//    private fun enviarNotificacao() {
//        // Cria a notificação
//        val builder = NotificationCompat.Builder(this, "meu_canal_id")
//            .setSmallIcon(R.drawable.ic_launcher_foreground)  // Ícone pequeno da notificação
//            .setContentTitle("Título da Notificação")           // Título da notificação
//            .setContentText("Esta é uma notificação de teste.") // Texto da notificação
//            .setPriority(NotificationCompat.PRIORITY_MAX)   // Prioridade da notificação
//
//        // Envia a notificação
//        val manager = getSystemService(NotificationManager::class.java)
//        manager?.notify(1, builder.build())  // ID = 1 para essa notificação
//    }

//    private fun mostrarModal(modal: Int) {
//        val builder = AlertDialog.Builder(this)
//        val inflater = LayoutInflater.from(this)
//        val view = inflater.inflate(modal, null)
//
//        builder.setView(view)
//        val dialog = builder.create()
//        dialog.show()

//        val closeButton: Button = view.findViewById(R.id.button_try_again)
//        closeButton.setOnClickListener {
//            dialog.dismiss() // Fecha o modal ao clicar no botão
//        }
//    }
    }
}