package com.mctable.namodule.di

import com.mctable.core.network.HttpClientBuilder
import com.mctable.namodule.features.nahome.data.networking.webservice.ServantHomeWebService
import com.mctable.namodule.features.nahome.presentation.viewmodels.NaHomePageViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create

@InstallIn(SingletonComponent::class)
@Module
object CoreModule {
    @Provides
    fun getServantHomeWebService() =
        HttpClientBuilder.buildRetrofit()

    @Provides
    fun getWebService(retrofit: Retrofit) = retrofit.create(ServantHomeWebService::class.java)

}