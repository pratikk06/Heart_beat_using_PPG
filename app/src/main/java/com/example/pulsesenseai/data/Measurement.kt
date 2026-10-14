package com.example.pulsesenseai.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "measurements")
data class Measurement(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val timestamp: Long,
    val durationMs: Long,
    val bpmPhaseDetector: Float?,
    val bpmPeakDetector: Float?,
    val signalQuality: Float,
    val algorithmUsed: String,
    val valid: Boolean
)
