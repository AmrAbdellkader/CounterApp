package com.example.counter_data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * local counter entity
 */
@Entity(tableName = "counter_table")
data class LocalCounter(
    /**
     * counter Id
     */
    @PrimaryKey
    val id: Int = 0,
    /**
     * counter Number
     */
    val number: Int
)
