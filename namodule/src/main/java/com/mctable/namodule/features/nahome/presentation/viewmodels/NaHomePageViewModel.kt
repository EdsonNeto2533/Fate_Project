package com.mctable.namodule.features.nahome.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mctable.core.utils.classes.UIState
import com.mctable.namodule.features.nahome.domain.model.ServantModel
import com.mctable.namodule.features.nahome.domain.usecase.GetServantsByNameUseCase
import com.mctable.namodule.features.nahome.domain.usecase.GetServantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NaHomePageViewModel @Inject constructor(
    private val getServantsUseCase: GetServantsUseCase,
    private val getServantsByNameUseCase: GetServantsByNameUseCase
) : ViewModel() {

    private val initialOffset = 0
    private val pageSize = 20
    private val servantList: MutableList<ServantModel> = mutableListOf()

    private val _showLoadingDialogState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val showLoadingDialogState = _showLoadingDialogState.asStateFlow()

    private val _servantsState: MutableStateFlow<UIState<List<ServantModel>>> =
        MutableStateFlow(UIState.Idle)
    val servantState = _servantsState.asStateFlow()

    fun getServants() {
        viewModelScope.launch {
            getServantsUseCase.execute(initialOffset, pageSize).collect {
                if (it is UIState.Success) {
                    servantList.addAll(it.data)
                }
                _servantsState.emit(it)
            }
        }
    }

    fun loadMoreServants(index: Int) {
        viewModelScope.launch {
            _showLoadingDialogState.emit(true)
            getServantsUseCase.execute(index + 1, pageSize).collect {
                if (it is UIState.Success) {
                    servantList.addAll(it.data)
                    _showLoadingDialogState.emit(false)
                    _servantsState.emit(UIState.Success(servantList))
                }
            }
        }
    }

    fun loadServantsByName(name: String) {
        viewModelScope.launch {
            getServantsByNameUseCase.execute(name).collect {
                _servantsState.emit(it)
            }
        }
    }

    fun resetList() {
        resetValues()
        getServants()
    }

    private fun resetValues() {
        servantList.clear()
    }

}