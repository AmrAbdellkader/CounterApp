package com.example.counter_domain

import com.example.counter_data.CounterRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 *
 */
@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    /**
     *
     */
    @Provides
    fun provideGetCounterUseCase(counterRepo: CounterRepo):
            GetCounterUseCase = GetCounterUseCase(counterRepo)

    /**
     *
     */
    @Provides
    fun provideUpdateCounterUseCase(counterRepo: CounterRepo):
            UpdateCounterUseCase = UpdateCounterUseCase(counterRepo)

}