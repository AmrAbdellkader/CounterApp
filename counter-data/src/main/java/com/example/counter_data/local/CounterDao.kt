package com.example.counter_data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

/**
 * database dao
 */
@Dao
interface CounterDao {

    /**
     * get counter
     */
    @Transaction
    @Query("select * from counter_table where id = 0")
    fun getCounter(): Flow<LocalCounter?>

    /**
     * update counter
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCounter(localCounter: LocalCounter)
}