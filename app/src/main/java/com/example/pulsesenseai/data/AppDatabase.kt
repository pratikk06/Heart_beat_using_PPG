package com.example.pulsesenseai.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pulsesenseai.data.MeasurementDao

@Database(entities = [Measurement::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun measurementDao(): MeasurementDao
}
