package com.example.krsnaism.dagger

import com.example.krsnaism.view.authorization.auth.fragment.RegistrationFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeRegistrationFragment(): RegistrationFragment
}