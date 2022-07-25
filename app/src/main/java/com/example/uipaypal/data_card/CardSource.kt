package com.example.uipaypal.data_card

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CardSource(resources: Resources) {
    private val initialCardList = CardList(resources)
    private val cardLiveData = MutableLiveData(initialCardList)


    fun getCardList(): LiveData<List<Card>> {
        return cardLiveData
    }

    companion object{
        private var INSTANCE: CardSource? = null

        fun getDataSource(resources: Resources): CardSource {
            return synchronized(CardSource::class) {
                val newInstance = INSTANCE ?: CardSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}