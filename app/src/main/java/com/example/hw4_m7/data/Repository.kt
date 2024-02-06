package com.example.hw4_m7.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.hw4_m7.App
import kotlinx.coroutines.Dispatchers

class Repository {
    fun addStatistic(model: StatisticModel): LiveData<Long> = liveData(Dispatchers.IO) {
        val insertedId = App.db.staticDao().insert(model)
        emit(insertedId)
    }


    fun getStatistic(): LiveData<List<StatisticModel>> = liveData(Dispatchers.Main) {
        emit(App.db.staticDao().getAll())
    }
}