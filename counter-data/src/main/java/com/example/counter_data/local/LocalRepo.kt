package com.example.counter_data.local

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalRepo @Inject constructor(private val counterDao: CounterDao) {

    fun getNumberStream(): Flow<LocalCounter?> = counterDao.getCounter()

    suspend fun updateNumber(localCounter: LocalCounter) = counterDao.updateCounter(localCounter)

}