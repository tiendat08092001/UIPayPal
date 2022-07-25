package com.example.uipaypal.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uipaypal.datauser.DataSource

class MainActivityViewModel(val dataSource: DataSource) : ViewModel() {
    val usersLiveData = dataSource.getUserList()

}

class UserListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainActivityViewModel(
                dataSource = DataSource.getDataSource(context.resources)
                ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}