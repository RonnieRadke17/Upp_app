package com.example.upp_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.upp_app.ui.theme.screen.login.LoginScreen
import com.example.upp_app.ui.theme.screen.register.RegisterScreen
import com.example.upp_app.ui.theme.screen.verification.VerificationScreen
import com.example.upp_app.ui.theme.screen.users.UserListScreen

@Composable
fun NavigationHelper() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ) {
        composable(Routes.LOGIN) {
            LoginScreen(navController)
        }
        composable(Routes.REGISTER) {
            RegisterScreen(navController)
        }
        composable(Routes.VERIFICATION) {
            VerificationScreen(navController)
        }
        composable(Routes.HOME) {
            UserListScreen(navController)
        }
    }
}
