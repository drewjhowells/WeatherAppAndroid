package com.example.weatherapp.API

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherAPI {
	@GET("/forecast?location=city&apikey=API_KEY")
	suspend fun getDayForecast(@Path("APIKey") key: String, @Query("city") city: String) : Result<List<DayForecast>>
}

