package com.mctable.namodule.features.nahome.domain.repository

import arrow.core.Either
import com.mctable.namodule.features.nahome.domain.model.ServantModel

interface ServantsRepository {
    suspend fun getServants(offset: Int, pageSize: Int, servantClass: String?): Either<Throwable, List<ServantModel>>

    suspend fun getServantsByName(name: String): Either<Throwable, List<ServantModel>>
}