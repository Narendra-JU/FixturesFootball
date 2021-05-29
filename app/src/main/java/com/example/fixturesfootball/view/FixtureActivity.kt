package com.example.fixturesfootball.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fixturesfootball.R
import com.example.fixturesfootball.model.countries.Countries
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_fixture.*

class FixtureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fixture)
        val navController = findNavController(R.id.fragNavHost)

        // Setting Navigation Controller with the BottomNavigationView
        bottomNavView.setupWithNavController(navController)

        val appBarConfiguration= AppBarConfiguration(
            topLevelDestinationIds = setOf(
                R.id.previousWeekMatches,
                R.id.listOfTeamsMatches,
                R.id.nextWeekMatches

            )
        )
        setupActionBarWithNavController(navController,appBarConfiguration)


    }

}