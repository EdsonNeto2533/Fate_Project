package com.mctable.namodule.di

import com.mctable.core.network.HttpClientBuilder
import com.mctable.namodule.features.nahome.data.networking.webservice.ServantHomeWebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object CoreModule {

    @Provides
    fun buildRetrofit() =
        HttpClientBuilder.buildRetrofit()


    @Provides
    fun getWebService(retrofit: Retrofit) = retrofit.create(ServantHomeWebService::class.java)

}