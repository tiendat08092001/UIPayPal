package com.example.uipaypal.data_activity

data class HistoryTrade(
    val name: String,
    val isAccept: Boolean,
    val isSend: Boolean,
    val value: Int
) {
}