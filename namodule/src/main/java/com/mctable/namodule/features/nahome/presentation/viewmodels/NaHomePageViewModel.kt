package com.mctable.namodule.features.nahome.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mctable.core.utils.classes.UIState
import com.mctable.namodule.features.nahome.data.networking.webservice.ServantHomeWebService
import com.mctable.namodule.features.nahome.domain.model.ServantModel
import com.mctable.namodule.features.nahome.domain.usecase.GetServantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NaHomePageViewModel @Inject constructor(
    private val getServantsUseCase: GetServantsUseCase
) : ViewModel() {

    private val _servantsState = mutableStateOf<UIState<List<ServantModel>>>(UIState.Idle)

    fun getServants() {
        viewModelScope.launch {
            getServantsUseCase.execute(0, 20).collect {
                _servantsState.value = it
            }
        }
    }

}