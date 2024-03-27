package com.example.weatherapp.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitInstance {
	companion object {
		fun getRetrofitInstance(): Retrofit {
			return Retrofit.Builder()
				.baseUrl("https://api.tomorrow.io/v4/weather/")
				.addConverterFactory(GsonConverterFactory.create())
				.build()
		}
	}

}