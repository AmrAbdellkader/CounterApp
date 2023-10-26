package com.example.counter_feature

import com.example.counter_domain.DomainCounter

fun DomainCounter.toUICounter() = UiCounter(number = number)
