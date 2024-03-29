package com.example.weatherapp.API

import com.google.gson.annotations.SerializedName


data class Forecast (

  @SerializedName("timelines" ) var timelines : Timelines? = Timelines(),
  @SerializedName("location"  ) var location  : Location?  = Location()

)