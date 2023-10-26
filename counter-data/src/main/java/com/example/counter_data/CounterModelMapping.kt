package com.example.counter_data

import com.example.counter_data.local.LocalCounter
import com.example.counter_data.network.NetworkCounter

/**
 *
 */
fun LocalCounter.toCounter(): Counter = Counter(number = number)

/**
 *
 */
fun Counter.toNetworkCounter(): NetworkCounter = NetworkCounter(number = number)

/**
 *
 */
fun NetworkCounter.toLocalCounter(): LocalCounter = LocalCounter(number = number)
