package com.mctable.namodule.features.nahome.data.repository

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.mctable.core.utils.functions.FunctionsUtil
import com.mctable.core.utils.interfaces.Mapper
import com.mctable.namodule.features.nahome.data.networking.datasource.ServantsDataSource
import com.mctable.namodule.features.nahome.data.response.ServantResponse
import com.mctable.namodule.features.nahome.domain.model.ServantModel
import com.mctable.namodule.features.nahome.domain.repository.ServantsRepository
import javax.inject.Inject

class ServantsRepositoryImpl @Inject constructor(
    private val servantsDataSource: ServantsDataSource,
    private val getServantsMapper: Mapper<List<ServantResponse>, List<ServantModel>>
) : ServantsRepository {
    override suspend fun getServants(
        offset: Int,
        pageSize: Int
    ): Either<Throwable, List<ServantModel>> {
        return try {
            val response = servantsDataSource.getServants(offset, pageSize)

            if (response.code() == 200) {
                response.body()?.data?.let {
                    return getServantsMapper.transform(it).right()
                }
            }

            Exception(FunctionsUtil.getGenericErrorMessage(response)).left()
        } catch (e: Exception) {
            e.left()
        }
    }

}