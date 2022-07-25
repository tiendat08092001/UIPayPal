package com.example.uipaypal.pay

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.uipaypal.R

class PayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)
        setSupportActionBar(findViewById(R.id.pay_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }
}