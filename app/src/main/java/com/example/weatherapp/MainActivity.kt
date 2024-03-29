package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.navigation.BottomNavigationBar
import com.example.weatherapp.navigation.Navigation
import com.example.weatherapp.navigation.BottomNavItem

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			val navController = rememberNavController()
			Scaffold (
				bottomBar = {
					BottomNavigationBar(
						items = listOf(
							BottomNavItem(
								name = "Day",
								route = "day",
								icon = Icons.Default.Home
							),
							BottomNavItem(
								name = "Week",
								route = "week",
								icon = Icons.Default.DateRange
							),
							BottomNavItem(
								name = "User",
								route = "user",
								icon = Icons.Default.AccountCircle
							)
						),
						navController = navController,
						modifier = Modifier.background(Color.Black),
						onItemClick = {
							navController.navigate(it.route)
						}
					)
				}
			) {paddingValue ->
				Surface (
					modifier = Modifier
						.padding(paddingValue)
						.fillMaxSize(),
					color = Color.White
				){
					Navigation(navController = navController)
				}
			}
		}
	}
}

