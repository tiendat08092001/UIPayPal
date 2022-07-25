package com.example.uipaypal.main

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uipaypal.R
import com.example.uipaypal.data_activity.HistoryTrade

class HistoryTradeAdapter(private val onClick: (HistoryTrade) -> Unit) :
    ListAdapter<HistoryTrade, HistoryTradeAdapter.HistoryTradeViewHolder>(HistoryTraderDiffCallback) {


    class HistoryTradeViewHolder(itemView: View, val onClick: (HistoryTrade) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val historyTradeTextViewName: TextView =
            itemView.findViewById(R.id.history_trade_name)
        private val historyTradeTextViewIsAccept: TextView =
            itemView.findViewById(R.id.history_trade_isaccept)
        private val historyTradeValue: TextView =
            itemView.findViewById(R.id.history_trade_value)
        private var currentHistoryTrade: HistoryTrade? = null

        init {
            itemView.setOnClickListener {
                currentHistoryTrade?.let {
                    onClick(it)
                }
            }
        }

        fun bind(historyTrade: HistoryTrade) {
            currentHistoryTrade = historyTrade
            historyTradeTextViewName.text = currentHistoryTrade?.name
            if (currentHistoryTrade!!.isAccept) {
                historyTradeTextViewIsAccept.text = "Pago aceptado"
            } else {
                historyTradeTextViewIsAccept.text = "no acepta"
            }

            if (currentHistoryTrade!!.isSend) {
                historyTradeValue.text = "-${currentHistoryTrade?.value}€"
                historyTradeValue.setTextColor(Color.parseColor("#1b1b1b"))
            } else {
                historyTradeValue.text = "+${currentHistoryTrade?.value}€"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryTradeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.history_trade_adapter, parent, false)
        return HistoryTradeViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: HistoryTradeViewHolder, position: Int) {
        val historyTrade = getItem(position)
        holder.bind(historyTrade)
    }
}


object HistoryTraderDiffCallback : DiffUtil.ItemCallback<HistoryTrade>() {
    override fun areItemsTheSame(oldItem: HistoryTrade, newItem: HistoryTrade): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HistoryTrade, newItem: HistoryTrade): Boolean {
        return oldItem.name == newItem.name
    }
}