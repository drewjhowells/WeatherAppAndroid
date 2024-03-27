package com.example.weatherapp.API

import com.google.gson.annotations.SerializedName


data class Timelines (

  @SerializedName("minutely" ) var minutely : ArrayList<Minutely> = arrayListOf(),
  @SerializedName("hourly"   ) var hourly   : ArrayList<Hourly>   = arrayListOf(),
  @SerializedName("daily"    ) var daily    : ArrayList<Daily>    = arrayListOf()

)