package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.weatherapp.API.RetrofitInstance
import com.example.weatherapp.API.WeatherAPI
import com.example.weatherapp.API.Forecast
import kotlinx.coroutines.runBlocking
import com.example.weatherapp.basicComposables.LoginScreen
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			//DisplayWeatherData()
			//LoginActivity()
			LoginScreen { email, password ->
				// Handle login logic here
				// For demonstration, just printing email and password
				println("Email: $email, Password: $password")
			}
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

/*class LoginActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			LoginScreen { email, password ->
				// Handle login logic here
				// For demonstration, just printing email and password
				println("Email: $email, Password: $password")
			}
		}
	}
}*/

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	LoginScreen { _, _ -> }
}