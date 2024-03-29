package com.example.weatherapp

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
fun WeekForecast() {
	val retrofitService = RetrofitInstance.getRetrofitInstance().create(WeatherAPI::class.java)
	var forecast : Forecast?
	runBlocking {
		forecast = retrofitService.getForecastByCity("Rexburg").body()
	}
	val forecastState by remember {
		mutableStateOf(forecast)
	}
	for (i in 0..6) {
		forecast?.timelines?.daily?.get(i)?.values?.temperatureAvg?.toString()?.let {
			Text(text = "Temperature: $it")
		}
	}

}