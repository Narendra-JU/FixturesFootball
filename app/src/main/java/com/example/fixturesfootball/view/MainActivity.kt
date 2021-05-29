package com.example.fixturesfootball.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fixturesfootball.R
import com.example.fixturesfootball.model.countries.Countries
import com.example.fixturesfootball.viewmodel.MainActivityViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var adapter: CountriesRecyclerAdapter
    private lateinit var tempList:ArrayList<Countries.Result>
    private lateinit var finalCountryList:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        recyclerViewMainActivity.layoutManager=LinearLayoutManager(this)
        viewModel.refresh()
        btnSelectRandomCountryList.setOnClickListener {
            viewModel.countriesList.value.let {
                var tempArrayList=it!!
                tempArrayList.shuffle()
                tempList= arrayListOf()
                for (i in 0..15){
                tempList.add(tempArrayList[i])
                }
                adapter= CountriesRecyclerAdapter(tempList)
                recyclerViewMainActivity.adapter=adapter
                btnFixtures.isEnabled=true
                btnFixtures.isClickable=true

                finalCountryList= arrayListOf()
                for(i in tempList){
                   finalCountryList.add(i.name)
                }


            }
        }

        btnFixtures.setOnClickListener {
        val intent=Intent(this, FixtureActivity::class.java)
            intent.putExtra("countryList",finalCountryList)
            startActivity(intent)
        }

    }
    private fun observeViewModel(){
        viewModel.refresh()
        /*viewModel.countriesList.observe(
            this,
            Observer { getCountries->
                getCountries.let {
                    adapter= CountriesRecyclerAdapter(getCountries)
                    recyclerViewMainActivity.adapter=adapter
                }

            }
        )*/
    }


}