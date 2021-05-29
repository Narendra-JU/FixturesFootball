package com.example.fixturesfootball.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fixturesfootball.model.countries.Countries
import com.example.fixturesfootball.model.network.CountriesService
import kotlinx.coroutines.*

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    var countriesService = CountriesService.getCountriesDataService()
    var countriesList = MutableLiveData<ArrayList<Countries.Result>>()
    var finalCountryList= MutableLiveData<ArrayList<Countries.Result>>()

    fun refresh() {
        fetchCountries()
    }




    private fun fetchCountries() {
        CoroutineScope(Dispatchers.IO).launch{
            val response=countriesService.getCountriesData()
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    countriesList.value= response.body()?.result as ArrayList<Countries.Result>?
                    Log.d("TESTINGGGG", "fetchCountries: ${countriesList.value}")
                }
            }

        }

    }


}