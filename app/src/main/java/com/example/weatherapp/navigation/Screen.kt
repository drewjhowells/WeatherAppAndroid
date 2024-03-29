package com.example.weatherapp.navigation

sealed class Screen(val route: String) {
	object DayScreen : Screen("dayScreen")
	object WeekScreen : Screen("weekScreen")

	object UserScreen : Screen("userScreen")

}