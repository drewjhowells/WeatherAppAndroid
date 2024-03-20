package com.example.weatherapp.API

import MinuteForecastValues

data class MinuteForecast(
	val time: String,
	val values: MinuteForecastValues
)
