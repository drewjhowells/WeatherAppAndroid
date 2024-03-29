package com.example.weatherapp.API

import com.google.gson.annotations.SerializedName


data class Minutely (

  @SerializedName("time"   ) var time   : String? = null,
  @SerializedName("values" ) var values : Values? = Values()

)