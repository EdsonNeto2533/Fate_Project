package com.mctable.namodule.features.nahome.data.networking.datasource

import com.mctable.namodule.features.nahome.data.response.ServantResponse
import retrofit2.Response

interface ServantsDataSource {
    suspend fun getServants(offset: Int, pageSize: Int): Response<ServantResponse>
}