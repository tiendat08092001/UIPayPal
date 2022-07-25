package com.example.uipaypal.data_activity

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataSourceHistoryTrade(resources: Resources) {
    private val initialHistoryTradeList = historyTradesList(resources)
    private val historyTradesLiveData = MutableLiveData(initialHistoryTradeList)


    fun getHistoryTradeList(): LiveData<List<HistoryTrade>> {
        return historyTradesLiveData
    }

    companion object {
        private var INSTANCE: DataSourceHistoryTrade? = null

        fun getDataSource(resources: Resources): DataSourceHistoryTrade {
            return synchronized(DataSourceHistoryTrade::class) {
                val newInstance = INSTANCE ?: DataSourceHistoryTrade(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}