package com.example.sheduleapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MonthsAdapter(
    private val months: List<String>,
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<MonthsAdapter.MonthViewHolder>() {

    inner class MonthViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMonthName: TextView = itemView.findViewById(R.id.tvMonthName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_month, parent, false)
        return MonthViewHolder(view)
    }

    override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {
        holder.tvMonthName.text = months[position]
        holder.itemView.setOnClickListener {
            onClick(position)
        }
    }

    override fun getItemCount(): Int = months.size
}
