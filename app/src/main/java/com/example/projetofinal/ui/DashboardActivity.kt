package com.example.projetofinal.ui

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.projetofinal.R
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import android.widget.ListView
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.core.content.ContextCompat

class DashboardActivity : AppCompatActivity() {

    private lateinit var pieChart: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_screen)

        // Configurar botão de retorno
        val btnReturn = findViewById<ImageView>(R.id.imageView2)
        btnReturn.setOnClickListener {
            finish()
        }

        // 1. Inicializar e configurar o gráfico de pizza
        setupPieChart()

        // 2. Configurar a lista de produtos em falta
        setupProductsOutOfStock()

        // 3. Configurar os funcionários com mais retiradas
        setupEmployeesWithMostWithdrawals()
    }

    private fun setupPieChart() {
        pieChart = findViewById(R.id.pieChart)

        // Configurações básicas
        pieChart.description.isEnabled = false
        pieChart.setUsePercentValues(true)
        pieChart.setEntryLabelTextSize(12f)
        pieChart.setEntryLabelColor(Color.BLACK)
        pieChart.centerText = "Saídas"
        pieChart.setCenterTextSize(16f)
        pieChart.setHoleColor(Color.WHITE)
        pieChart.setTransparentCircleAlpha(0)
        pieChart.setDrawEntryLabels(false)
        pieChart.legend.isEnabled = true
        pieChart.legend.textSize = 12f
        pieChart.legend.horizontalAlignment = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.CENTER

        // Dados para o gráfico (estáticos)
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(35f, "Canetas"))
        entries.add(PieEntry(25f, "Papel A4"))
        entries.add(PieEntry(20f, "Grampos"))
        entries.add(PieEntry(15f, "Clips"))
        entries.add(PieEntry(5f, "Outros"))

        // Cores para o gráfico
        val colors = ArrayList<Int>()
        for (color in ColorTemplate.MATERIAL_COLORS) {
            colors.add(color)
        }

        // Criar dataset e formatar
        val dataSet = PieDataSet(entries, "Produtos")
        dataSet.colors = colors
        dataSet.sliceSpace = 3f
        dataSet.selectionShift = 5f

        // Criar PieData e formatar
        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter(pieChart))
        data.setValueTextSize(12f)
        data.setValueTextColor(Color.BLACK)

        // Aplicar dados ao gráfico
        pieChart.data = data
        pieChart.invalidate() // Atualizar gráfico
        pieChart.animateY(1400)
    }

    private fun setupProductsOutOfStock() {
        // Produtos em falta
        val frameProductsFailed = findViewById<View>(R.id.frame_products_failed)

        // Criar ListView dinamicamente dentro do FrameLayout
        val listView = ListView(this)
        listView.layoutParams = android.widget.FrameLayout.LayoutParams(
            android.widget.FrameLayout.LayoutParams.MATCH_PARENT,
            android.widget.FrameLayout.LayoutParams.MATCH_PARENT
        )

        // Adicionar margem para não sobrepor o título
        val params = listView.layoutParams as android.widget.FrameLayout.LayoutParams
        params.topMargin = resources.getDimensionPixelSize(R.dimen.list_top_margin) // Definir um valor em dimens.xml
        listView.layoutParams = params

        // Lista de produtos em falta
        val productsOutOfStock = arrayOf(
            "Canetas Esferográficas - Azul",
            "Papel A4 - Resma 500 folhas",
            "Cartuchos de Tinta - HP 664",
            "Grampeador - Médio",
            "Fita Adesiva Transparente",
            "Pasta Suspensa"
        )

        // Adaptador simples para a lista
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            productsOutOfStock
        )

        listView.adapter = adapter

        // Adicionar ListView ao FrameLayout
        (frameProductsFailed as android.widget.FrameLayout).addView(listView)
    }

    private fun setupEmployeesWithMostWithdrawals() {
        // Frame dos funcionários
        val frameEmployees = findViewById<View>(R.id.frame_products_more_exits)

        // Adicionar nomes dos funcionários e estatísticas embaixo das imagens
        val layout = frameEmployees as android.widget.FrameLayout

        // Adicionar texto para o primeiro funcionário
        addEmployeeStats(
            layout,
            "João Silva",
            "127 retiradas",
            Gravity.START,
            R.color.primary_color
        )

        // Adicionar texto para o segundo funcionário
        addEmployeeStats(
            layout,
            "Maria Oliveira",
            "98 retiradas",
            Gravity.CENTER_HORIZONTAL,
            R.color.primary_variant
        )

        // Adicionar texto para o terceiro funcionário
        addEmployeeStats(
            layout,
            "Pedro Santos",
            "76 retiradas",
            Gravity.END,
            R.color.border_color
        )
    }

    private fun addEmployeeStats(
        layout: android.widget.FrameLayout,
        name: String,
        stats: String,
        gravity: Int,
        colorResId: Int
    ) {
        // TextView para nome
        val nameTextView = TextView(this)
        nameTextView.text = name
        nameTextView.textSize = 14f
        nameTextView.setTextColor(ContextCompat.getColor(this, colorResId))
        nameTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER

        val nameParams = android.widget.FrameLayout.LayoutParams(
            android.widget.FrameLayout.LayoutParams.WRAP_CONTENT,
            android.widget.FrameLayout.LayoutParams.WRAP_CONTENT
        )
        nameParams.gravity = gravity or Gravity.BOTTOM
        nameParams.bottomMargin = resources.getDimensionPixelSize(R.dimen.employee_name_margin_bottom) // ~35dp
        nameTextView.layoutParams = nameParams

        // TextView para estatísticas
        val statsTextView = TextView(this)
        statsTextView.text = stats
        statsTextView.textSize = 12f
        statsTextView.setTextColor(Color.GRAY)
        statsTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER

        val statsParams = android.widget.FrameLayout.LayoutParams(
            android.widget.FrameLayout.LayoutParams.WRAP_CONTENT,
            android.widget.FrameLayout.LayoutParams.WRAP_CONTENT
        )
        statsParams.gravity = gravity or Gravity.BOTTOM
        statsParams.bottomMargin = resources.getDimensionPixelSize(R.dimen.employee_stats_margin_bottom) // ~15dp
        statsTextView.layoutParams = statsParams

        // Adicionar views ao layout
        layout.addView(nameTextView)
        layout.addView(statsTextView)
    }
}