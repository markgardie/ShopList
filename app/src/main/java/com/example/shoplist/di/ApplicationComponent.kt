package com.example.shoplist.di

import android.app.Application
import com.example.shoplist.presentation.activities.MainActivity
import com.example.shoplist.presentation.fragments.ShopItemFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DataModule::class,
        CoroutineScopeModule::class,
        ViewModelModule::class]
)
@ApplicationScope
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: ShopItemFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            application: Application
        ): ApplicationComponent
    }
}