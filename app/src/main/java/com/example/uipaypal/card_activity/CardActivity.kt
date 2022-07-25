package com.example.uipaypal.card_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uipaypal.R
import com.example.uipaypal.data_card.Card

class CardActivity : AppCompatActivity() {
    private val cardListViewModel by viewModels<CardViewModel> {
        CardsListViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)
        setSupportActionBar(findViewById(R.id.card_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //recycleView cards
        val cardAdapter = CardAdapter { card -> cardAdapterOnCLick(card) }
        val recyclerViewCard = findViewById<RecyclerView>(R.id.recycle_view_mycard)
        val linearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewCard.adapter = cardAdapter
        recyclerViewCard.layoutManager = linearLayoutManager
        cardListViewModel.cardsLiveData.observe(this) {
            it?.let {
                cardAdapter.submitList(it as MutableList<Card>)
            }
        }
    }

    private fun cardAdapterOnCLick(card: Card) {
        Toast.makeText(this, "$card", Toast.LENGTH_SHORT).show()
    }
}