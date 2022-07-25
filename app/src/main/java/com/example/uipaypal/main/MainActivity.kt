package com.example.uipaypal.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uipaypal.R
import com.example.uipaypal.card_activity.CardActivity
import com.example.uipaypal.data_activity.HistoryTrade
import com.example.uipaypal.datauser.User
import com.example.uipaypal.pay.PayActivity
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {
    private val newMainActivityRequestCode = 1
    private val usersListViewModel by viewModels<MainActivityViewModel> {
        UserListViewModelFactory(this)
    }

    private val historyTradeViewModel by viewModels<HistoryTradeViewModel> {
        HistoryTradeViewModelFactory(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //list user
        val userAdapter = UserViewAdapter { user -> adapterOnClick(user) }
        val linearLayoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view_user)
        recyclerView.adapter = userAdapter
        recyclerView.layoutManager = linearLayoutManager
        usersListViewModel.usersLiveData.observe(this) {
            it?.let {
                userAdapter.submitList(it as MutableList<User>)
            }
        }

        //list history trade
        val historyTradeAdapter =
            HistoryTradeAdapter { historyTrade -> historyTradeAdapterOnClick(historyTrade) }
        val linearLayoutManagerHistoryTrade =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        val recyclerViewHistoryTrade: RecyclerView = findViewById(R.id.recycle_view_activity)
        recyclerViewHistoryTrade.adapter = historyTradeAdapter
        recyclerViewHistoryTrade.layoutManager = linearLayoutManagerHistoryTrade
        historyTradeViewModel.historyTradesLiveData.observe(this) {
            it?.let {
                historyTradeAdapter.submitList(it as MutableList<HistoryTrade>)
            }
        }

        val imageUser = findViewById<CircleImageView>(R.id.profile_image)
        imageUser.setOnClickListener {
            val intent = Intent(this@MainActivity, CardActivity::class.java)
            startActivity(intent)
        }

    }

    private fun historyTradeAdapterOnClick(historyTrade: HistoryTrade) {
        Toast.makeText(this@MainActivity, "$historyTrade", Toast.LENGTH_SHORT).show()
    }


    private fun adapterOnClick(user: User) {
        Toast.makeText(this@MainActivity, "${user.name}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this@MainActivity, PayActivity::class.java)
        startActivity(intent)
    }
}