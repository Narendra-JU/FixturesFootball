package com.example.fixturesfootball.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fixturesfootball.R
import com.example.fixturesfootball.model.countries.Countries
import com.example.fixturesfootball.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_list_of_teams_matches.*
import java.security.acl.Group


/**
 * A simple [Fragment] subclass.
 * Use the [ListOfTeamsMatches.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListOfTeamsMatches : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_of_teams_matches, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var arrayList=activity?.intent?.getStringArrayListExtra("countryList")


        val temp0= mutableListOf<String>()
        val temp1= mutableListOf<String>()
        val temp2= mutableListOf<String>()
        val temp3= mutableListOf<String>()

        for (i in 0..3){
            if (arrayList != null) {
                temp0.add(arrayList[i])
                temp1.add(arrayList[i+4])
                temp2.add(arrayList[i+8])
                temp3.add(arrayList[i+12])

            }
        }


        rv_teamA.layoutManager=LinearLayoutManager(context)
        rv_teamA.adapter=CountriesRecyclerAdapter(
            arrayListOf(
                Countries.Result("1",temp0[0],"null"),
                Countries.Result("2",temp0[1],"null"),
                Countries.Result("3",temp0[2],"null"),
                Countries.Result("4",temp0[3],"null")
            )
        )

        rv_teamB.layoutManager=LinearLayoutManager(context)
        rv_teamB.adapter=CountriesRecyclerAdapter(
            arrayListOf(
                Countries.Result("1",temp1[0],"null"),
                Countries.Result("2",temp1[1],"null"),
                Countries.Result("3",temp1[2],"null"),
                Countries.Result("4",temp1[3],"null")
            )
        )

        rv_teamC.layoutManager=LinearLayoutManager(context)
        rv_teamC.adapter=CountriesRecyclerAdapter(
            arrayListOf(
                Countries.Result("1",temp2[0],"null"),
                Countries.Result("2",temp2[1],"null"),
                Countries.Result("3",temp2[2],"null"),
                Countries.Result("4",temp2[3],"null")
            )
        )

        rv_teamD.layoutManager=LinearLayoutManager(context)
        rv_teamD.adapter=CountriesRecyclerAdapter(
            arrayListOf(
                Countries.Result("1",temp3[0],"null"),
                Countries.Result("2",temp3[1],"null"),
                Countries.Result("3",temp3[2],"null"),
                Countries.Result("4",temp3[3],"null")
            )
        )







    }
}