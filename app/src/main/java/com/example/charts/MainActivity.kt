package com.example.charts

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.charts.databinding.ActivityMainBinding
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        var myChart: PieChart = binding.pieChart1

        var dataList: ArrayList<PieEntry> = arrayListOf()
        dataList.add(PieEntry(5F, "Auto"))
        dataList.add(PieEntry(1F, "Bici"))
        dataList.add(PieEntry(7F, "Bus"))
        dataList.add(PieEntry(3F, "Avion"))
        dataList.add(PieEntry(8F, "Moto"))

        //
        val dataSet = PieDataSet(dataList,"Resultados")

        val colors:ArrayList<Int> = ArrayList()
        for (c in ColorTemplate.JOYFUL_COLORS){
            colors.add(c)
        }

        dataSet.colors = colors
        val data = PieData(dataSet)

        val num = binding.edtxt.text.toInt()

        myChart.setData(data)

        binding.button.setOnClickListener{
            dataList.clear()
            for (i in 0 until 5){
                dataList.add(PieEntry(((Math.random() * num ) + 5).toFloat()))
            }
        }


    }
}