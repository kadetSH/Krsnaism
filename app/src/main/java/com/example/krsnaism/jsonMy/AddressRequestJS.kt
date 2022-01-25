package com.example.krsnaism.jsonMy

import com.google.gson.annotations.SerializedName

data class AddressRequestJS(
    @SerializedName("locations") val locations : List<Locations>,
    @SerializedName("restrict_value") val restrict_value : Boolean,
    @SerializedName("from_bound") val from_bound : From_bound,
    @SerializedName("to_bound") val to_bound : To_bound,
    @SerializedName("query") val query : String,
    @SerializedName("count") val count : Int
)
