package com.example.krsnaism.jsonMy

import com.google.gson.annotations.SerializedName

data class Suggestions(
    @SerializedName("value") val value : String,
    @SerializedName("unrestricted_value") val unrestricted_value : String,
    @SerializedName("data") val data : DataJS
)
