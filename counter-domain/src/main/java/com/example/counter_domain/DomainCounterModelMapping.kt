package com.example.counter_domain

import com.example.counter_data.Counter


fun Counter.toDomainCounter() = DomainCounter(number = number.toString())
