package com.example.pulsesenseai.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavController = rememberNavController()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "PulseSense AI", style = androidx.compose.material3.MaterialTheme.typography.headlineMedium)
        Text(text = "Experimental heart‑rate measurement using smartphone camera", modifier = Modifier.padding(top = 8.dp))
        Button(
            onClick = { /* TODO: navigate to measurement screen */ },
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Text("Start Measurement")
        }
        // Additional navigation buttons can be added here
    }
}
