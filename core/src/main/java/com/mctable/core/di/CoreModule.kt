package com.mctable.core.di

import com.mctable.core.network.HttpClientBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    fun buildRetrofit(): Retrofit =
        HttpClientBuilder.buildRetrofit()

}