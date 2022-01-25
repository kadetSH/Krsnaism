package com.example.krsnaism.jsonMy

import com.google.gson.annotations.SerializedName

data class AddressAnswerJS(
    @SerializedName("suggestions") val suggestions : List<Suggestions>
)
