package com.mctable.namodule.features.nahome.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mctable.core.utils.classes.UIState
import com.mctable.namodule.features.nahome.domain.model.ServantModel
import com.mctable.namodule.features.nahome.domain.usecase.GetServantsByNameUseCase
import com.mctable.namodule.features.nahome.domain.usecase.GetServantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
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
    private var classFilter: String? = null

    private val _showLoadingDialogState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val showLoadingDialogState = _showLoadingDialogState.asStateFlow()

    private val _enableLoadMore: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val enableLoadMore = _enableLoadMore.asStateFlow()

    private val _servantsState: MutableStateFlow<UIState<List<ServantModel>>> =
        MutableStateFlow(UIState.Idle)
    val servantState = _servantsState.asStateFlow()

    fun getServants() {
        viewModelScope.launch {
            getServantsUseCase.execute(initialOffset, pageSize, classFilter).collect {
                if (it is UIState.Success) {
                    _enableLoadMore.emit(it.data.isNotEmpty())
                    servantList.addAll(it.data)
                }
                _servantsState.emit(it)
            }
        }
    }

    fun loadMoreServants(index: Int) {
        viewModelScope.launch {
            _showLoadingDialogState.emit(true)
            getServantsUseCase.execute(index + 1, pageSize, classFilter).collect {
                if(it !is UIState.Loading){
                    _showLoadingDialogState.emit(false)
                }
                if (it is UIState.Success) {
                    _enableLoadMore.emit(it.data.isNotEmpty())
                    servantList.addAll(it.data)
                    _servantsState.emit(UIState.Success(servantList))
                }
            }
        }
    }

    fun loadServantsByName(name: String) {
        viewModelScope.launch {
            getServantsByNameUseCase.execute(name).collect {
                classFilter = null
                _enableLoadMore.emit(false)
                _servantsState.emit(it)
            }
        }
    }

    fun resetList() {
        resetValues()
        getServants()
    }

    fun filterServantsByClass(servantClass: String?) {
        classFilter = servantClass
        resetList()
    }

    private fun resetValues() {
        servantList.clear()
    }

}