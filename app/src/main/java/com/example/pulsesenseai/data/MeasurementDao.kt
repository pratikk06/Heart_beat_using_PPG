// Measurement Data Access Object (DAO) for Room
package com.example.pulsesenseai.data

import com.example.pulsesenseai.data.Measurement

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MeasurementDao {
    // Insert a measurement; replace on conflict
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(measurement: Measurement)

    // Retrieve all measurements ordered by newest first
    @Query("SELECT * FROM measurements ORDER BY timestamp DESC")
    suspend fun getAll(): List<Measurement>
}
