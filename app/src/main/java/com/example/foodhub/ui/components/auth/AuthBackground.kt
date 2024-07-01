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
    Box(modifier = Modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxWidth()) { // Top circle decoration
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

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(30.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White)
                .size(38.dp)
                .clickable {

                }
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Back"
            )
        }
    }
}