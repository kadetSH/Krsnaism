package com.example.krsnaism.view.authorization.auth.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.krsnaism.App
import javax.inject.Inject

class RegistrationViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application) {

    private val interactor = App.instance.registrationInteractor

    fun getCityList(){
        interactor.getCityList2()
    }

}