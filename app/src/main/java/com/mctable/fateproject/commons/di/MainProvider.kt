package com.mctable.fateproject.commons.di

import com.mctable.commons.ds.navigation.FateNavigation
import com.mctable.commons.ds.navigation.FateNavigationImpl
import com.mctable.commons.ds.navigation.Routes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object MainProvider {

    @Provides
    fun appNavigation(): FateNavigation =
        FateNavigationImpl(startDestination = Routes.SPLASH)
}