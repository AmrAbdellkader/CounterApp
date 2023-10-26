package com.example.counter_data

import com.example.counter_data.local.LocalRepo
import com.example.counter_data.network.NetworkCounter
import com.example.counter_data.network.NetworkRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

/**
 *
 */
class CounterRepo @Inject constructor(
    private val localRepo: LocalRepo,
    private val networkRepo: NetworkRepo
) {

    /**
     *
     */
    fun getNumberStream(): Flow<Counter> = localRepo.getNumberStream().map {
        it?.toCounter() ?: Counter(0)
    }


    /**
     *
     */
    suspend fun updateNumber(counter: Counter) {
        networkRepo.updateNumber(counter.toNetworkCounter())
        refresh()
    }

    private suspend fun refresh() {
        val counter: NetworkCounter? =
            networkRepo.getNumberStream().await().getValue(NetworkCounter::class.java)
        counter?.let {
            localRepo.updateNumber(counter.toLocalCounter())
        }
    }
}