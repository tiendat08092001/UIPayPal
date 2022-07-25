package com.example.uipaypal.datauser

import androidx.annotation.DrawableRes

data class User(
    val id: Long,
    val name: String,
    @DrawableRes
    val image: Int?,
)