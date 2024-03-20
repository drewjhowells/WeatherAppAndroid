package com.example.weatherapp.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
	val api : WeatherAPI by lazy {
		Retrofit.Builder()
			.baseUrl("https://api.tomorrow.io/v4/weather")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(WeatherAPI::class.java)
	}
}