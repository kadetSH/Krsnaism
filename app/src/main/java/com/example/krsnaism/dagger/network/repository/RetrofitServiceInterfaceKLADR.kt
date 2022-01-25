package com.example.krsnaism.dagger.network.repository

import com.example.krsnaism.jsonMy.AddressAnswerJS
import com.example.krsnaism.jsonMy.AddressRequestJS
import io.reactivex.Observable
import retrofit2.http.*


interface RetrofitServiceInterfaceKLADR {

    @POST("address")
    fun getVisitsList(
        @Body requestAddress: AddressRequestJS,
        @Header("Authorization") authHeader: String?,
        @Header("Content-Type") contentType: String?
    ): Observable<AddressAnswerJS>

}