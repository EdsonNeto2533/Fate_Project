package com.mctable.namodule.features.nahome.data.networking.webservice

import com.mctable.namodule.features.nahome.data.response.ServantResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServantHomeWebService {

    @GET("/servants")
    suspend fun getServants(
        @Query("offset") offset: Int,
        @Query("pageSize") pageSize: Int,
    ): Response<List<ServantResponse>>
}