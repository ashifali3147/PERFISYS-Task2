package com.tlw.perfisystask2.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.tlw.perfisystask2.model.BottomNavItems
import com.tlw.perfisystask2.ui.navigation.BottomNavigationBar
import com.tlw.perfisystask2.ui.navigation.Navigation
import com.tlw.perfisystask2.ui.route.Screen

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold(bottomBar = {
                BottomNavigationBar(
                    navItem = listOf(
                        BottomNavItems(
                            "Home",
                            Screen.HomeScreen.route,
                            Icons.Filled.Home,
                            Icons.Outlined.Home
                        ),
                        BottomNavItems(
                            "Saved",
                            Screen.SavedScreen.route,
                            Icons.Filled.Favorite,
                            Icons.Outlined.FavoriteBorder
                        ),
                        BottomNavItems(
                            "Profile",
                            Screen.ProfileScreen.route,
                            Icons.Filled.AccountCircle,
                            Icons.Outlined.AccountCircle
                        )
                    ),
                    navController = navController,
                    onItemClick = { navController.navigate(it.route) }
                )
            }) {innerPadding ->
                // Apply the padding globally to the whole BottomNavScreensController
                Box(modifier = Modifier.padding(innerPadding)) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    PERFISYSTask2Theme {
//        Greeting("Android")
//    }
//}