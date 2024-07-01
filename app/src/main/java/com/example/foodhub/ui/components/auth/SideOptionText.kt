package com.example.foodhub.ui.components.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodhub.ui.theme.clickableOptionStyle
import com.example.foodhub.ui.theme.sideOptionText
import com.example.foodhub.ui.theme.sofiaPro

@Composable
fun SideOptionText(
    message: String,
    option: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.padding(top = 15.dp)
    ) {
        Text(
            text = message,
            style = TextStyle(
                color = sideOptionText,
                fontFamily = sofiaPro,
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp
            )
        )
        Text(
            text = option,
            style = clickableOptionStyle,
            modifier = Modifier.clickable {
                onClick
            }
        )
    }
}