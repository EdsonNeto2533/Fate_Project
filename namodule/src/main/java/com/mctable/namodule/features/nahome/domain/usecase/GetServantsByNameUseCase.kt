package com.mctable.namodule.features.nahome.domain.usecase

import com.mctable.core.utils.classes.UIState
import com.mctable.namodule.features.nahome.domain.model.ServantModel
import kotlinx.coroutines.flow.Flow

interface GetServantsByNameUseCase {
    fun execute(name: String): Flow<UIState<List<ServantModel>>>
}