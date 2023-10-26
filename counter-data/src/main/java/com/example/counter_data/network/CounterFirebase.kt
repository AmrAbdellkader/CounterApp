package com.example.counter_data.network

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase

/**
 *
 */
class CounterFirebase() {
    private val myRef = FirebaseDatabase.getInstance().reference.child("counter")

    /**
     *
     */
    fun updateCounter(networkCounter: NetworkCounter): Task<Void> = myRef.setValue(networkCounter)


    /**
     *
     */
    fun getCounter(): Task<DataSnapshot> = myRef.get()


}