package com.mctable.namodule.features.nahome.domain.repository

import arrow.core.Either
import com.mctable.namodule.features.nahome.domain.model.ServantModel

interface ServantsRepository {
    suspend fun getServants(offset: Int, pageSize: Int): Either<Throwable, List<ServantModel>>
}