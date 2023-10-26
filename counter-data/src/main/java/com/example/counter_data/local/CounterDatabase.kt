package com.example.counter_data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * room database class
 */
@Database(entities = [LocalCounter::class], version = 1, exportSchema = false)
abstract class CounterDatabase: RoomDatabase(){
    /**
     * counter dao
     */
    abstract fun counterDao(): CounterDao

}