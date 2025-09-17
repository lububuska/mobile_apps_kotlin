package com.example.sheduleapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CalendarActivity : AppCompatActivity() {

    private lateinit var rvMonths: RecyclerView
    private val monthNames = listOf(
        "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
        "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        rvMonths = findViewById(R.id.rvMonths)
        rvMonths.layoutManager = GridLayoutManager(this, 3)

        val adapter = MonthsAdapter(monthNames) { monthIndex ->
            val intent = Intent(this, MonthActivity::class.java)
            intent.putExtra("monthIndex", monthIndex)
            intent.putExtra("year", 2025) // можно менять динамически
            startActivity(intent)
        }

        rvMonths.adapter = adapter
    }
}
