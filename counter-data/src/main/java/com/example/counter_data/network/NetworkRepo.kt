package com.example.counter_data.network

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import javax.inject.Inject

/**
 *
 */
class NetworkRepo @Inject constructor(private val counterFirebase: CounterFirebase) {

    /**
     *
     */
    fun getNumberStream(): Task<DataSnapshot> = counterFirebase.getCounter()

    /**
     *
     */
    fun updateNumber(networkCounter: NetworkCounter): Task<Void> = counterFirebase.updateCounter(networkCounter)

}