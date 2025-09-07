package com.example.sheduleapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_day = findViewById<Button>(R.id.buttonDay)
        val button_calendar = findViewById<Button>(R.id.buttonCalendar)
        val button_homework = findViewById<Button>(R.id.buttonHomework)
    }
}
