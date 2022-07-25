package com.example.uipaypal.data_activity

import android.content.res.Resources

fun historyTradesList(resources: Resources) : List<HistoryTrade> {
    val a = listOf(
        HistoryTrade(name = "El corte inglés", isAccept = true, isSend = true, value = 150),
        HistoryTrade(name = "Maria Lujan", isAccept = true, isSend = false, value = 1650),
        HistoryTrade(name = "Maria Lujan", isAccept = true, isSend = false, value = 1250),
        HistoryTrade(name = "Maria Lujan", isAccept = true, isSend = false, value = 3250),
        HistoryTrade(name = "Maria Lujan", isAccept = true, isSend = true, value = 2250),
        HistoryTrade(name = "Maria Lujan", isAccept = true, isSend = false, value = 4250),
        HistoryTrade(name = "Maria Lujan", isAccept = true, isSend = true, value = 6250),
    )
    return a.reversed().take(3)
}