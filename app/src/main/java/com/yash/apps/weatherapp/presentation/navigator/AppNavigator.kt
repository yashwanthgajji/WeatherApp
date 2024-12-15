package com.yash.apps.weatherapp.presentation.navigator

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yash.apps.weatherapp.presentation.home.HomeScreen
import com.yash.apps.weatherapp.presentation.home.HomeViewModel
import com.yash.apps.weatherapp.presentation.search.SearchScreen
import com.yash.apps.weatherapp.presentation.search.components.SearchViewModel

@Composable
fun AppNavigator(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value
    Scaffold { innerPadding ->
        NavHost(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            navController = navController,
            startDestination = Route.HomeScreen.route
        ) {
            composable(route = Route.HomeScreen.route) {
                val homeViewModel: HomeViewModel = hiltViewModel()
                HomeScreen(
                    viewModel = homeViewModel,
                    navigateToSearch = { navigateToTab(navController, Route.SearchScreen.route) }
                )
            }
            composable(route = Route.SearchScreen.route) {
                val searchViewModel: SearchViewModel = hiltViewModel()
                SearchScreen(
                    viewModel = searchViewModel,
                    navigateBack = { navController.navigateUp() }
                )
            }
        }
    }
}

private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { homeScreen ->
            popUpTo(homeScreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}