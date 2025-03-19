package com.example.projetofinal

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alert_after_registraton_screen)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { view, insets ->
            val systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBarsInsets.left, systemBarsInsets.top, systemBarsInsets.right, systemBarsInsets.bottom)
            insets
        }
//        val pieChart = findViewById<PieChart>(R.id.pieChart)
//        val entries = ArrayList<PieEntry>()
//        entries.add(PieEntry(18.5f, "Green"))
//        entries.add(PieEntry(26.7f, "Yellow"))
//        entries.add(PieEntry(24.0f, "Red"))
//        entries.add(PieEntry(30.8f, "Blue"))
//        val dataSet = PieDataSet(entries, "Election Results").apply {
//            colors = listOf(Color.GREEN, Color.YELLOW, Color.RED, Color.BLUE)
//        }
//        val data = PieData(dataSet)
//        pieChart.data = data
//        pieChart.invalidate()


    }
}