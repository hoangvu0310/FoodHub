package com.example.foodhub.ui.components.auth

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun OtherOptionTextWithLine(
    text: String,
    strokeWidth: Float,
    lineColor: Color,
    style: TextStyle
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Canvas(modifier = Modifier.weight(1f)) {
            val canvasWidth = size.width

            drawLine(
                color = lineColor,
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = canvasWidth, y = 0f),
                alpha = 0.5f,
                strokeWidth = strokeWidth
            )
        }
        Text(
            text = text,
            style = style,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Canvas(modifier = Modifier.weight(1f)) {
            val canvasWidth = size.width

            drawLine(
                color = lineColor,
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = canvasWidth, y = 0f),
                alpha = 0.5f,
                strokeWidth = strokeWidth
            )
        }
    }
}