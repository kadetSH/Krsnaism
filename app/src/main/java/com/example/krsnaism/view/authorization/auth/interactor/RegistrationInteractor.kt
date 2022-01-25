package com.example.krsnaism.view.authorization.auth.interactor

import android.annotation.SuppressLint
import com.example.krsnaism.dagger.network.repository.RetrofitServiceInterfaceKLADR
import com.example.krsnaism.jsonMy.AddressRequestJS
import com.example.krsnaism.jsonMy.From_bound
import com.example.krsnaism.jsonMy.Locations
import com.example.krsnaism.jsonMy.To_bound
import io.reactivex.schedulers.Schedulers

class RegistrationInteractor(private val retrofitServiceInterfaceKLADR: RetrofitServiceInterfaceKLADR) {

    @SuppressLint("CheckResult")
    fun getCityList() {
        val locations: List<Locations> = listOf(Locations("город"))
        val restrictValue: Boolean = false

        val valueFromBound: String = "city"
        val fromBound: From_bound = From_bound(valueFromBound)

        val valueToBound: String = "city"
        val toBound: To_bound = To_bound(valueToBound)

        val query: String = "Бел"

        val count: Int = 5

        var addressRequest =
            AddressRequestJS(locations, restrictValue, fromBound, toBound, query, count)
        var qwe = retrofitServiceInterfaceKLADR.getVisitsList(addressRequest)
        qwe
            .subscribeOn(Schedulers.io())
            .doOnError {
                println("")
            }
            .subscribe({ result ->
                result.forEach { doc ->
                    println("")
                }
            }, { error ->
                println("")
            })
    }

    @SuppressLint("CheckResult")
    fun getCityList2() {
        val locations: List<Locations> = listOf(Locations("город"))
        val restrictValue: Boolean = false

        val valueFromBound: String = "city"
        val fromBound: From_bound = From_bound(valueFromBound)

        val valueToBound: String = "city"
        val toBound: To_bound = To_bound(valueToBound)

        val query: String = "Бел"

        val count: Int = 5

        var addressRequest =
            AddressRequestJS(locations, restrictValue, fromBound, toBound, query, count)
        var qwe = retrofitServiceInterfaceKLADR.getVisitsList2(addressRequest, "Token 516769fe93685fa955636eb7d1857ec1f669f6cf")
        qwe
            .subscribeOn(Schedulers.io())
            .doOnError {
                println("")
            }
            .subscribe({ result ->
                result.forEach { doc ->
                    println("")
                }
            }, { error ->
                println("")
            })
    }
}