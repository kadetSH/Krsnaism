package com.example.krsnaism.view.authorization.auth.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.krsnaism.App
import com.example.krsnaism.SingleLiveEvent
import com.example.krsnaism.jsonMy.AddressAnswerJS
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RegistrationViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application) {

    private val interactor = App.instance.registrationInteractor



    private var _citiesAnswer = SingleLiveEvent<ArrayList<String>>()
    val citiesAnswer: LiveData<ArrayList<String>> get() = _citiesAnswer

    fun getCityList(s: String) {
        val cities = interactor.getCityList(s)
            .subscribeOn(Schedulers.io())
            .doOnError {
                println("")
            }
            .subscribe({ result ->
                val cities = ArrayList<String>()
                result.suggestions.forEach {
                    val city = it.data.city
                    cities.add(city)
                }
                _citiesAnswer.postValue(cities)
                println()
            }, { error ->
                println("")
            })

    }

}