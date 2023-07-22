package com.mctable.core.network

import retrofit2.Retrofit

object FateWebService {

    inline fun <reified T> buildWebService(webService: T): T {
        return Retrofit.Builder()
            .baseUrl(UrlProvider.FATE_BASE_URL)
            .build()
            .create(T::class.java)
    }
}