package com.example.sheduleapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MonthActivity : AppCompatActivity() {

    private lateinit var rvDays: RecyclerView
    private lateinit var tvMonthYear: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_month)

        rvDays = findViewById(R.id.rvDays)
        tvMonthYear = findViewById(R.id.tvMonthYear)

        val monthIndex = intent.getIntExtra("monthIndex", 0) // 0 = январь
        val year = intent.getIntExtra("year", 2025)

        val monthNames = listOf(
            "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
            "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
        )

        tvMonthYear.text = "${monthNames[monthIndex]} $year"

        rvDays.layoutManager = GridLayoutManager(this, 7)

        val daysInMonth = getDaysInMonth(monthIndex, year)

        val adapter = DaysAdapter(daysInMonth) { day ->
            val intent = Intent(this, DayActivity::class.java)
            intent.putExtra("day", day)
            intent.putExtra("month", monthIndex)
            intent.putExtra("year", year)
            startActivity(intent)
        }

        rvDays.adapter = adapter
    }

    private fun getDaysInMonth(month: Int, year: Int): List<Int> {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        return (1..calendar.getActualMaximum(Calendar.DAY_OF_MONTH)).toList()
    }
}
