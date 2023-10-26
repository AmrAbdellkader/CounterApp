package com.example.counter_domain

import com.example.counter_data.Counter
import com.example.counter_data.CounterRepo
import javax.inject.Inject

/**
 *
 */
class UpdateCounterUseCase @Inject constructor(private val counterRepo: CounterRepo) {

    /**
     *
     */
    suspend operator fun invoke(number: String) {
        val newNumber = number.toInt() + 1
        counterRepo.updateNumber(Counter(newNumber))
    }
}