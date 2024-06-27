package com.example.foodhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.foodhub.ui.components.welcome.WelcomeScreen
import com.example.foodhub.ui.theme.FoodHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        installSplashScreen()
        Thread.sleep(1000)
        setContent {
            FoodHubTheme{
                WelcomeScreen()
            }
        }
    }
}
