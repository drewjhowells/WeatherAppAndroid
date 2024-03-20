package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapp.API.WeatherAPI
import com.example.weatherapp.ui.theme.WeatherAppTheme
import java.io.FileInputStream
import java.util.Properties

class MainActivity : ComponentActivity() {

	fun getAPI_KEY() : String {
		val fileInputStream = FileInputStream("secret.properties")
		val API_KEY = Properties()
		API_KEY.load(fileInputStream)
		fileInputStream.close()
		val value = API_KEY.getProperty("API_Key")
		return value
	}

	val API_KEY = getAPI_KEY()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			Greeting("Android")
			TextFieldEntry()
		}
	}
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
	Text(
		text = "Hello $name!",
		modifier = modifier
	)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	WeatherAppTheme {
		Greeting("Android")
	}
}

@Composable
fun TextFieldEntry() {
	Text(text = "Our name")
}