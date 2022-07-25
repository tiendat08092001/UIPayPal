package com.example.uipaypal.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uipaypal.data_activity.DataSourceHistoryTrade

class HistoryTradeViewModel(val dataSource: DataSourceHistoryTrade) : ViewModel() {
    val historyTradesLiveData = dataSource.getHistoryTradeList()
}

class HistoryTradeViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoryTradeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HistoryTradeViewModel(
                dataSource = DataSourceHistoryTrade.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}