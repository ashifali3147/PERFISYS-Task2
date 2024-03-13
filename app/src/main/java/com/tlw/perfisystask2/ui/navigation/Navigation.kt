package com.tlw.perfisystask2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tlw.perfisystask2.ui.route.Screen
import com.tlw.perfisystask2.ui.screen.HomeScreen
import com.tlw.perfisystask2.ui.screen.ProfileScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen()
        }
        composable(route = Screen.SavedScreen.route) {

        }
        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen()
        }

    }
}

