package com.example.weatherapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.weatherapp.API.Forecast
import com.example.weatherapp.API.RetrofitInstance
import com.example.weatherapp.API.WeatherAPI
import kotlinx.coroutines.runBlocking

@Composable
fun DayForecast() {
	val retrofitService = RetrofitInstance.getRetrofitInstance().create(WeatherAPI::class.java)
	var forecast : Forecast?
	runBlocking {
		forecast = retrofitService.getForecastByCity("Rexburg").body()
	}
	val forecastState by remember {
		mutableStateOf(forecast)
	}
	forecast?.timelines?.daily?.get(0)?.values?.temperatureAvg?.toString()?.let {
		Text(text = "Temperature: $it")
	}
}