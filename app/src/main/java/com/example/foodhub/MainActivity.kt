package com.example.foodhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.foodhub.ui.view.auth.LogInScreen
import com.example.foodhub.ui.theme.FoodHubTheme
import com.example.foodhub.ui.view.auth.SignUpScreen
import com.example.foodhub.ui.view.auth.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        installSplashScreen()
        Thread.sleep(1000)
        setContent {
            FoodHubTheme{
                LogInScreen()
            }
        }
    }
}
