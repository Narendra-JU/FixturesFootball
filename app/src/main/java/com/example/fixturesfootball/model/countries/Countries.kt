package com.example.fixturesfootball.model.countries


import com.google.gson.annotations.SerializedName

data class Countries(
    @SerializedName("code")
    val code: Int,
    @SerializedName("extra")
    val extra: List<Any>,
    @SerializedName("result")
    val result: List<Result>
) {
    data class Result(
        @SerializedName("code")
        val code: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("states")
        val states: Any
    )
}