package com.mctable.namodule.features.nahome.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mctable.core.utils.classes.UIState
import com.mctable.namodule.features.nahome.domain.model.ServantModel
import com.mctable.namodule.features.nahome.domain.usecase.GetServantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NaHomePageViewModel @Inject constructor(
    private val getServantsUseCase: GetServantsUseCase
) : ViewModel() {

    private val _servantsState: MutableStateFlow<UIState<List<ServantModel>>> =
        MutableStateFlow(UIState.Idle)
    val servantState: StateFlow<UIState<List<ServantModel>>> = _servantsState.asStateFlow()

    fun getServants() {
        viewModelScope.launch {
            getServantsUseCase.execute(0, 20).collect {
                _servantsState.emit(it)
            }
        }
    }

}