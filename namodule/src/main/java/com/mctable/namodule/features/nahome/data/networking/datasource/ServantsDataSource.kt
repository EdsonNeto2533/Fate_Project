package com.mctable.namodule.features.nahome.data.networking.datasource

import com.mctable.core.utils.classes.BaseResponse
import com.mctable.namodule.features.nahome.data.response.ServantResponse
import retrofit2.Response

interface ServantsDataSource {
    suspend fun getServants(
        offset: Int,
        pageSize: Int,
        servantClass: String?
    ): Response<BaseResponse<List<ServantResponse>, Any>>

    suspend fun getServantsByName(name: String): Response<BaseResponse<List<ServantResponse>, Any>>
}