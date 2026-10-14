package com.example.pulsesenseai

import android.app.Application
import androidx.room.Room
import com.example.pulsesenseai.data.AppDatabase

class PulseSenseApplication : Application() {
    // Lazy singleton Room database instance
    val database: AppDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "pulsesense-db"
        ).fallbackToDestructiveMigration().build()
    }
}
