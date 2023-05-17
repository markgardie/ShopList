package com.example.shoplist.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

@Module
class CoroutineScopeModule {

    @Provides
    fun provideScope(): CoroutineScope {
        return CoroutineScope(Dispatchers.Main)
    }
}