package com.mctable.namodule.features.nahome.domain.usecase.impl

import com.mctable.core.utils.classes.GenericError
import com.mctable.core.utils.classes.UIState
import com.mctable.namodule.features.nahome.domain.model.ServantModel
import com.mctable.namodule.features.nahome.domain.repository.ServantsRepository
import com.mctable.namodule.features.nahome.domain.usecase.GetServantsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetServantsUseCaseImpl @Inject constructor(
    private val repository: ServantsRepository
) : GetServantsUseCase {
    override fun execute(offset: Int, pageSize: Int, servantClass: String?): Flow<UIState<List<ServantModel>>> = flow {
        emit(UIState.Loading)
        repository.getServants(offset, pageSize).fold(
            ifLeft = {
                emit(UIState.Failure(GenericError(it.message)))
            },
            ifRight = {
                emit(UIState.Success(it))
            },
        )
    }
}