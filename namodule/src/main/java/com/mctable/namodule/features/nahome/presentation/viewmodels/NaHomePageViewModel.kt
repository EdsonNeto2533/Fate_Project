package com.mctable.namodule.features.nahome.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mctable.namodule.features.nahome.data.networking.webservice.ServantHomeWebService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NaHomePageViewModel @Inject constructor(
    private val servantHomeWebService: ServantHomeWebService
) : ViewModel() {

    fun teste() {
        viewModelScope.launch {
            try {
                val alo = servantHomeWebService.getServants(0, 20)
                println(alo)
            } catch (e: Exception) {
                println(e)
            }

        }
    }
}