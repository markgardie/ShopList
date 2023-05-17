package com.example.shoplist.di

import android.app.Application
import com.example.shoplist.data.database.AppDatabase
import com.example.shoplist.data.database.ShopListDao
import com.example.shoplist.data.repositories.ShopListRepositoryImpl
import com.example.shoplist.domain.repositories.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideShopListDao(application: Application): ShopListDao {
            return AppDatabase.getInstance(application).shopListDao()
        }
    }

}