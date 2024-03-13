package com.tlw.perfisystask2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tlw.perfisystask2.ui.route.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
//            HomeScreen(navController)
        }
        composable(route = Screen.SavedScreen.route) {

        }
        composable(route = Screen.ProfileScreen.route) {

        }

    }
}

