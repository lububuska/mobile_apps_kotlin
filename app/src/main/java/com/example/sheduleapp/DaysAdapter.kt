package com.example.sheduleapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DaysAdapter(
    private val days: List<Int>,
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<DaysAdapter.DayViewHolder>() {

    inner class DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDayNumber: TextView = itemView.findViewById(R.id.tvDayNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_day, parent, false)
        return DayViewHolder(view)
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.tvDayNumber.text = days[position].toString()
        holder.itemView.setOnClickListener {
            onClick(days[position])
        }
    }

    override fun getItemCount(): Int = days.size
}
