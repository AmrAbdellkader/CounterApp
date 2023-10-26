package com.example.counter_feature

sealed interface CounterUIState {
    /**
     * The onboarding state is loading.
     */
    data object Loading : CounterUIState

    /**
     *
     */
    data class Success(val counter: UiCounter) : CounterUIState

}