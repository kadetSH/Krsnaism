package com.example.krsnaism.dagger

import android.app.Application
import com.example.krsnaism.App
import com.example.krsnaism.dagger.network.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
//        RoomModule::class,
        MainActivityModule::class
    ]
)
interface  AppComponent : AndroidInjector<App> {

//    fun resources(): ResourcesProvider

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
//        fun application(resourcesProvider: ResourcesProvider): Builder

        fun build(): AppComponent
    }

    override fun inject(app: App)



}