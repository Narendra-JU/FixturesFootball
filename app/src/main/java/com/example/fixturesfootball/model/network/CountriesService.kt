package com.example.fixturesfootball.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CountriesService {
    private val BASE_URL="https://api.printful.com/"

    fun getCountriesDataService():CountriesApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountriesApi::class.java)
    }
}