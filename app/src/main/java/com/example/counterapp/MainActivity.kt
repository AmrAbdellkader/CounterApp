package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.counter_feature.CounterRoute
import com.example.counterapp.ui.theme.CounterAppTheme
import com.google.firebase.FirebaseApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            CounterAppTheme {
                CounterRoute()
            }
        }
    }
}

