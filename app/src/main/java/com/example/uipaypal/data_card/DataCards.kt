package com.example.uipaypal.data_card

import android.content.res.Resources
import com.example.uipaypal.R

fun CardList(resources: Resources): List<Card> {
    return listOf(
        Card(id = 1, imageCard = R.drawable.ic_mastercard_2, "Mastercard", "****9889"),
        Card(id = 2, imageCard = R.drawable.ic_visa_card, "Visa black", "****8764"),
        Card(id = 3, imageCard = R.drawable.ic_visa_card, "Visa black", "****8764"),
    )
}