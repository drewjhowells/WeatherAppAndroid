package com.example.weatherapp.API

import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherAPI {
	@GET("forecast?")
	suspend fun getForecastByCity(
		@Query("location")
		city : String,
		@Query("apikey")
		apikey : String = "p7dA97aismeORMUUAMdpjnWT3uDzvsRW",
		@Query("units")
		units : String = "imperial"
	) : Response<Forecast>
}

