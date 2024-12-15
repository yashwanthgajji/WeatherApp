package com.yash.apps.weatherapp.presentation.navigator

sealed class Route(val route: String) {
    object HomeScreen: Route(route = "home")
    object SearchScreen: Route(route = "search")
}