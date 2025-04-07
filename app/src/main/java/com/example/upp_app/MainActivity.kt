package com.example.upp_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.upp_app.navigation.Routes
import com.example.upp_app.ui.theme.Upp_appTheme
import com.example.upp_app.ui.theme.screen.login.LoginScreen
import com.example.upp_app.ui.theme.screen.register.RegisterScreen
import com.example.upp_app.ui.theme.screen.users.UserListScreen
import com.example.upp_app.ui.theme.screen.verification.VerificationScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Upp_appTheme {
                val navController = rememberNavController()
                Surface(color = MaterialTheme.colorScheme.background) {
                    NavHost(
                        navController = navController,
                        startDestination = Routes.LOGIN // Puedes cambiarla según convenga
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
            }
        }
    }
}
