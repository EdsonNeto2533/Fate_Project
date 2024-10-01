package com.mctable.namodule.features.nahome.data.networking.datasource.impl

import com.mctable.core.utils.classes.BaseResponse
import com.mctable.namodule.features.nahome.data.networking.datasource.ServantsDataSource
import com.mctable.namodule.features.nahome.data.networking.webservice.ServantHomeWebService
import com.mctable.namodule.features.nahome.data.response.ServantResponse
import retrofit2.Response
import javax.inject.Inject

class ServantsDataSourceImpl @Inject constructor(
    private val webService: ServantHomeWebService
) : ServantsDataSource {
    override suspend fun getServants(
        offset: Int,
        pageSize: Int,
        servantClass: String?
    ): Response<BaseResponse<List<ServantResponse>, Any>> =
        webService.getServants(offset, pageSize, servantClass)

    override suspend fun getServantsByName(name: String): Response<BaseResponse<List<ServantResponse>, Any>> =
        webService.getServantsByName(name)
}