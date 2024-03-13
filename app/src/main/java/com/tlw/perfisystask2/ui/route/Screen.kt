package com.tlw.perfisystask2.ui.route

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object SavedScreen : Screen("saved_screen")
    object ProfileScreen : Screen("profile_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}