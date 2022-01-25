package com.example.krsnaism.view.authorization.auth.interactor

import android.annotation.SuppressLint
import com.example.krsnaism.dagger.network.repository.RetrofitServiceInterfaceKLADR
import com.example.krsnaism.jsonMy.*
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class RegistrationInteractor(private val retrofitServiceInterfaceKLADR: RetrofitServiceInterfaceKLADR) {



    @SuppressLint("CheckResult")
    fun getCityList(searchStr: String): Observable<AddressAnswerJS> {

        val locations: List<Locations> = listOf(Locations("город"))
        val restrictValue: Boolean = false

        val valueFromBound: String = "city"
        val fromBound: From_bound = From_bound(valueFromBound)

        val valueToBound: String = "city"
        val toBound: To_bound = To_bound(valueToBound)

        val query: String = searchStr

        val count: Int = 5

        val addressRequest =
            AddressRequestJS(locations, restrictValue, fromBound, toBound, query, count)
        return retrofitServiceInterfaceKLADR.getVisitsList(
            addressRequest,
            "Token 516769fe93685fa955636eb7d1857ec1f669f6cf",
            "application/json"
        )



    }
}