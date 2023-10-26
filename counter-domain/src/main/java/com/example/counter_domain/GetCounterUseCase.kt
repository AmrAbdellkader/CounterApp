package com.example.counter_domain

import com.example.counter_data.CounterRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 *
 */
class GetCounterUseCase @Inject constructor(private val counterRepo: CounterRepo)  {

    /**
     *
     */
    operator fun invoke(): Flow<DomainCounter> = counterRepo.getNumberStream().map {
            it.toDomainCounter()
    }
}