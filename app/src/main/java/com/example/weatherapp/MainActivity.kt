package com.example.weatherapp

import android.net.http.HttpException
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapp.API.RetrofitInstance
import com.example.weatherapp.API.WeatherAPI
import com.example.weatherapp.API.Forecast
import com.example.weatherapp.ui.theme.WeatherAppTheme
import kotlinx.coroutines.runBlocking
import java.io.FileInputStream
import java.util.Properties

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			DisplayWeatherData()

		}
	}
}

@Composable
fun DisplayWeatherData() {
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