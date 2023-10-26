package com.example.counter_data.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesCounterDatabase(@ApplicationContext context: Context,
    ): CounterDatabase = Room.databaseBuilder(
        context,
        CounterDatabase::class.java,
        "counter-database",
    ).build()

    @Provides
    fun providesCounterDao(
        database: CounterDatabase,
    ): CounterDao = database.counterDao()
}