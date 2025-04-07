package com.example.upp_app.navigation


import androidx.navigation.NavController

fun goTo(navController: NavController, route: String) {
    navController.navigate(route) {
        launchSingleTop = true
        restoreState = true
        popUpTo(navController.graph.startDestinationId) {
            saveState = true
        }
    }
}

