package com.mctable.fateproject.commons.di

import FateNavigationImpl
import android.content.Context
import com.mctable.commons.ds.navigation.FateNavigation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object MainProvider {


    @Provides
    fun appNavigation(
        @ApplicationContext
        context: Context
    ): FateNavigation =
        FateNavigationImpl(context)
}