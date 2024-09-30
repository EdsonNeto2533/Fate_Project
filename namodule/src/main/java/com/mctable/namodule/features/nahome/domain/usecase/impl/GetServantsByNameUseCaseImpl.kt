package com.mctable.namodule.features.nahome.domain.usecase.impl

import com.mctable.core.utils.classes.GenericError
import com.mctable.core.utils.classes.UIState
import com.mctable.namodule.features.nahome.domain.model.ServantModel
import com.mctable.namodule.features.nahome.domain.repository.ServantsRepository
import com.mctable.namodule.features.nahome.domain.usecase.GetServantsByNameUseCase
import com.mctable.namodule.features.nahome.domain.usecase.GetServantsUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetServantsByNameUseCaseImpl @Inject constructor(
    private val repository: ServantsRepository
) : GetServantsByNameUseCase {
    override fun execute(name: String): Flow<UIState<List<ServantModel>>> = flow {
        emit(UIState.Loading)
        delay(3000)
        repository.getServantsByName(name).fold(
            ifLeft = {
                emit(UIState.Failure(GenericError(it.message)))
            },
            ifRight = {
                emit(UIState.Success(it))
            },
        )
    }
}