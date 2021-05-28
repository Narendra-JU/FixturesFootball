package com.example.fixturesfootball.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fixturesfootball.R
import com.example.fixturesfootball.model.countries.Countries
import kotlinx.android.synthetic.main.item_mainactivityrecycler.view.*

class CountriesRecyclerAdapter(var countriesList:ArrayList<Countries.Result>):
    RecyclerView.Adapter<CountriesRecyclerAdapter.MyHolder>() {
    class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        private var countryCode=itemView.tv_countrycode
        private var countryName=itemView.tv_countryName
        fun bind(arrayListCountry:Countries.Result){
            countryCode.text=arrayListCountry.code
            countryName.text=arrayListCountry.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_mainactivityrecycler,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var countrieslst=countriesList[position]
        holder.bind(countrieslst)
    }

    override fun getItemCount(): Int {
        return countriesList.size
    }
}