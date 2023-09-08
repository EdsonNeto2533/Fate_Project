package com.mctable.core.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpClientBuilder {

    fun buildRetrofit(): Retrofit {
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(Interceptors.loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(UrlProvider.FATE_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }
}