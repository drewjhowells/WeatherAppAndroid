package com.example.weatherapp.API

import com.google.gson.annotations.SerializedName


data class Location (

  @SerializedName("lat"  ) var lat  : Double? = null,
  @SerializedName("lon"  ) var lon  : Double? = null,
  @SerializedName("name" ) var name : String? = null,
  @SerializedName("type" ) var type : String? = null

)