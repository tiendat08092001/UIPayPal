package com.example.uipaypal.datauser

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataSource(resource: Resources) {
    private val inittialUserList = userList(resource)
    private val userLiveData = MutableLiveData(inittialUserList)

    fun getUserForId(id: Long): User? {
        userLiveData.value?.let { users ->
            return users.firstOrNull { it.id == id }
        }
        return null
    }

    fun getUserList(): LiveData<List<User>> {
        return userLiveData
    }

    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(resource: Resources): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resource)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}