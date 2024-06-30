package com.example.foodhub.ui.components.auth

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.foodhub.ui.theme.otherAuthOption

@Composable
fun AuthenticationButton(
    @DrawableRes iconId: Int,
    text: String,
    elevation: Dp,
    authenticate: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        elevation = ButtonDefaults.buttonElevation(elevation),
        contentPadding = PaddingValues(end = 20.dp),
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 15.dp),
        onClick = authenticate
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = text,
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 15.dp)
                .size(35.dp)
        )
        Text(
            text = text,
            style = otherAuthOption,
            textAlign = TextAlign.Center,
        )
    }
}