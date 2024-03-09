package com.example.workoutmanger11.workoutTracker.presentation.overViewScreen

import com.example.workoutmanger11.workoutTracker.domain.Repository
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class OverViewViewModel(val repository : Repository) : ViewModel() {

    val _uiState = MutableStateFlow(OverViewUIState())

    val uiState = combine(
        _uiState ,repository.getExercise()
    ){ _state,data->
        if(data.isEmpty())
        _state.copy(name = "emit", exercise = data)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), OverViewUIState())


}