package com.mctable.namodule.features.nahome.data.networking.webservice

import com.mctable.core.utils.classes.BaseResponse
import com.mctable.namodule.features.nahome.data.response.ServantResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServantHomeWebService {

    @GET("/servants")
    suspend fun getServants(
        @Query("offset") offset: Int,
        @Query("pageSize") pageSize: Int,
        @Query("className") servantClass: String?
    ): Response<BaseResponse<List<ServantResponse>, Any>>

    @GET("/servants/{name}")
    suspend fun getServantsByName(
        @Path("name") name: String,
    ): Response<BaseResponse<List<ServantResponse>, Any>>
}