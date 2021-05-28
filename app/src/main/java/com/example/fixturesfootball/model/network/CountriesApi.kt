package com.example.fixturesfootball.model.network

import com.example.fixturesfootball.model.countries.Countries
import retrofit2.Response
import retrofit2.http.GET

interface CountriesApi {
    //https://api.printful.com/countries
    @GET("countries")
    suspend fun getCountriesData():Response<Countries>


}