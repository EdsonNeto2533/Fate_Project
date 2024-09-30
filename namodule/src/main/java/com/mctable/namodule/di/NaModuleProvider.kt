package com.mctable.namodule.di

import com.mctable.core.network.HttpClientBuilder
import com.mctable.namodule.features.nahome.data.networking.datasource.ServantsDataSource
import com.mctable.namodule.features.nahome.data.networking.datasource.impl.ServantsDataSourceImpl
import com.mctable.namodule.features.nahome.data.networking.mapper.ServantResponseToModelMapper
import com.mctable.namodule.features.nahome.data.networking.webservice.ServantHomeWebService
import com.mctable.namodule.features.nahome.data.repository.ServantsRepositoryImpl
import com.mctable.namodule.features.nahome.domain.repository.ServantsRepository
import com.mctable.namodule.features.nahome.domain.usecase.GetServantsByNameUseCase
import com.mctable.namodule.features.nahome.domain.usecase.GetServantsUseCase
import com.mctable.namodule.features.nahome.domain.usecase.impl.GetServantsByNameUseCaseImpl
import com.mctable.namodule.features.nahome.domain.usecase.impl.GetServantsUseCaseImpl
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
    fun getWebService(retrofit: Retrofit): ServantHomeWebService =
        retrofit.create(ServantHomeWebService::class.java)

    @Provides
    fun getServantsDataSource(service: ServantHomeWebService): ServantsDataSource =
        ServantsDataSourceImpl(service)

    @Provides
    fun getServantsRepository(dataSource: ServantsDataSource): ServantsRepository =
        ServantsRepositoryImpl(dataSource, ServantResponseToModelMapper())

    @Provides
    fun getServantsUseCase(repository: ServantsRepository): GetServantsUseCase =
        GetServantsUseCaseImpl(repository)

    @Provides
    fun getServantsByNameUseCase(repository: ServantsRepository): GetServantsByNameUseCase =
        GetServantsByNameUseCaseImpl(repository)

}