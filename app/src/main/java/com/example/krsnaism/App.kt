package com.example.krsnaism

import com.example.krsnaism.dagger.DaggerAppComponent
import com.example.krsnaism.dagger.network.repository.RetrofitServiceInterfaceKLADR
import com.example.krsnaism.view.authorization.auth.interactor.RegistrationInteractor
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject


class App : DaggerApplication() {

    @Inject
    lateinit var retrofitServiceInterfaceKLADR: RetrofitServiceInterfaceKLADR

    lateinit var registrationInteractor: RegistrationInteractor

    override fun onCreate() {
        super.onCreate()
        instance = this
        initInteractor()
    }

    private fun initInteractor() {
        registrationInteractor = RegistrationInteractor(
            retrofitServiceInterfaceKLADR
        )
    }

    private val applicationInjector = DaggerAppComponent.builder().application(this).build()
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector

    companion object {
        lateinit var instance: App
            private set
    }

}