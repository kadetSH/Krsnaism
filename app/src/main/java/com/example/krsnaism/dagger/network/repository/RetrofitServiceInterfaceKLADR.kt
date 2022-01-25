package com.example.krsnaism.dagger.network.repository

import com.example.krsnaism.jsonMy.AddressAnswerJS
import com.example.krsnaism.jsonMy.AddressRequestJS
import io.reactivex.Observable
import retrofit2.http.*


interface RetrofitServiceInterfaceKLADR {

    @POST("address")
    @Headers("Authorization:Token 516769fe93685fa955636eb7d1857ec1f669f6cf")
    fun getVisitsList(
        @Body requestAddress: AddressRequestJS

    ): Observable<ArrayList<AddressAnswerJS>>


    @POST("address")
//    @Headers("Authorization:Token 516769fe93685fa955636eb7d1857ec1f669f6cf")
    fun getVisitsList2(
        @Body requestAddress: AddressRequestJS,
        @Header("Authorization") authHeader: String?
    ): Observable<ArrayList<AddressAnswerJS>>

}