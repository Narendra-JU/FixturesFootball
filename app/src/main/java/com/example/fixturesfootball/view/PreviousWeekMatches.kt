package com.example.fixturesfootball.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fixturesfootball.R
import com.example.fixturesfootball.model.countries.Countries
import kotlinx.android.synthetic.main.fragment_previous_week_matches.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class PreviousWeekMatches : Fragment() {

    private lateinit var countriesArrayList: ArrayList<Countries.Result>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_previous_week_matches, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var arrayList = activity?.intent?.getStringArrayListExtra("countryList")


        val temp0 = mutableListOf<String>()
        val temp1 = mutableListOf<String>()
        val temp2 = mutableListOf<String>()
        val temp3 = mutableListOf<String>()
        val fixture = mutableListOf<String>()

        for (i in 0..3) {
            if (arrayList != null) {
                temp0.add(arrayList[i])
                temp1.add(arrayList[i + 4])
                temp2.add(arrayList[i + 8])
                temp3.add(arrayList[i + 12])
            }
        }

        for (i in 0..3) {
            for (j in 0..3) {
                if (j != i) {
                    fixture.add("Group A ${temp0.get(j)} vs ${temp0.get(i)}")
                    fixture.add("Group B ${temp1.get(j)} vs ${temp1.get(i)}")
                }

            }
        }
        countriesArrayList= arrayListOf()
        var no=0
        for (i in fixture){

            no += 1
            countriesArrayList.add(Countries.Result("$no",i,""))
        }
        rv_previousDayMatches.layoutManager=LinearLayoutManager(context)
        rv_previousDayMatches.adapter=CountriesRecyclerAdapter(countriesArrayList)







    }
}