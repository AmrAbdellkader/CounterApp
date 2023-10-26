package com.example.counter_feature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

/**
 *
 */
@Composable
fun CounterRoute(viewModel: CounterViewModel = hiltViewModel()) {
    val counterUIState by viewModel.counterUIState.collectAsStateWithLifecycle()

    Surface(modifier = Modifier.fillMaxSize()) {
        CounterScreen(counterUIState, viewModel::updateCounter)
    }
}

@Composable
internal fun CounterScreen(
    counterUIState: CounterUIState,
    updateCounter: (String) -> Unit,
    modifier: Modifier = Modifier,
) {

    var oldNumber by remember {
        mutableStateOf("0")
    }
    SideEffect {
        when (counterUIState) {
            CounterUIState.Loading -> {}
            is CounterUIState.Success -> oldNumber = counterUIState.counter.number
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = oldNumber, modifier = modifier)

        Button(onClick = { updateCounter(oldNumber) }) {
            Text(text = "Update Counter")
        }
        if (counterUIState == CounterUIState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.padding(16.dp),
                color = Color.Green,
                strokeWidth = Dp(value = 4F)
            )
        }
    }
}

