package com.example.foodhub.ui.components.auth

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.foodhub.ui.theme.appOrange
import com.example.foodhub.ui.theme.circleBeige

@Composable
fun AuthBackground() {
    // Top circle back ground decoration
    Box(modifier = Modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxWidth()) {
            val canvasWidth = size.width

            drawCircle(
                color = appOrange,
                radius = 96f * 2,
                center = Offset(x = 5f, y = 75f)
            )
            drawCircle(
                color = Color.White,
                radius = 25f * 2,
                center = Offset(x = 5f, y = 75f)
            )
            drawCircle(
                color = circleBeige,
                radius = 165f * 2,
                center = Offset(x = 320f, y = -90f)
            )
            drawCircle(
                color = appOrange,
                radius = 181f * 2,
                center = Offset(x = canvasWidth + 100f, y = -30f)
            )

        }
    }
}