package com.example.counter_feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.counter_domain.GetCounterUseCase
import com.example.counter_domain.UpdateCounterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *
 */
@HiltViewModel
class CounterViewModel @Inject constructor(
    private val updateCounterUseCase: UpdateCounterUseCase,
    getCounterUseCase: GetCounterUseCase) : ViewModel() {


    /**
     *
     */
    val counterUIState: StateFlow<CounterUIState> =
        getCounterUseCase()
            .map {
                CounterUIState.Success(it.toUICounter())
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = CounterUIState.Loading,
            )

    /**
     *
     */
    fun updateCounter(number: String) {
        viewModelScope.launch {
            updateCounterUseCase(number)
        }
    }
}