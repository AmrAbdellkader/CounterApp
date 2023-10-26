package com.example.counter_data

import com.example.counter_data.local.CounterDao
import com.example.counter_data.local.LocalRepo
import com.example.counter_data.network.CounterFirebase
import com.example.counter_data.network.NetworkRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    /**
     *
     */
    @Provides
    fun provideCounterRepository(localRepo: LocalRepo, networkRepo: NetworkRepo):
            CounterRepo = CounterRepo(localRepo, networkRepo)

    /**
     *
     */
    @Provides
    @Singleton
    fun provideCounterFirebaseRepository(): CounterFirebase = CounterFirebase()
    /**
     *
     */
    @Provides
    @Singleton
    fun provideNetworkRepository(counterFirebase: CounterFirebase):
            NetworkRepo = NetworkRepo(counterFirebase)

    /**
     *
     */
    @Provides
    @Singleton
    fun provideLocalRepository(counterDao: CounterDao):
            LocalRepo = LocalRepo(counterDao)
}