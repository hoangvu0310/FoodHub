package com.example.foodhub.ui.components.auth

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodhub.R
import com.example.foodhub.ui.theme.appOrange
import com.example.foodhub.ui.theme.authOption
import com.example.foodhub.ui.theme.clickableOption
import com.example.foodhub.ui.theme.otherAuthOption
import com.example.foodhub.ui.theme.line
import com.example.foodhub.ui.theme.sideOptionText
import com.example.foodhub.ui.theme.sofiaPro

@Composable
fun AuthenticationOption(
    mainOption: String,
    sideText: String,
    sideOption: String,
    otherOptionText: String,
    isEmptyFields: Boolean,
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = appOrange,
            disabledContainerColor = Color.Gray
        ),
        enabled = !isEmptyFields,
        elevation = ButtonDefaults.buttonElevation(3.dp),
        modifier = Modifier
            .width(248.dp)
            .height(60.dp),
        onClick = { /*TODO*/ }
    ) {
        Text(
            text = mainOption,
            style = authOption
        )
    }

    Spacer(modifier = Modifier.size(20.dp))

    Row(
        modifier = Modifier.padding(top = 15.dp)
    ) {
        Text(
            text = sideText,
            style = TextStyle(
                color = sideOptionText,
                fontFamily = sofiaPro,
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp
            )
        )
        Text(
            text = sideOption,
            style = clickableOption,
            modifier = Modifier.clickable {

            }
        )
    }

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 35.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth()
    ) {
        Canvas(modifier = Modifier.weight(1f)) {
            val canvasWidth = size.width

            drawLine(
                color = line,
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = canvasWidth, y = 0f),
                alpha = 0.5f,
                strokeWidth = 3f
            )
        }
        Text(
            text = otherOptionText,
            style = TextStyle(
                color = sideOptionText,
                fontFamily = sofiaPro,
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp
            ),
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Canvas(modifier = Modifier.weight(1f)) {
            val canvasWidth = size.width

            drawLine(
                color = line,
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = canvasWidth, y = 0f),
                alpha = 0.5f,
                strokeWidth = 3f
            )
        }
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {
        OtherOptionButton(iconId = R.drawable.fb_icon, text = "FACEBOOK") {

        }
        OtherOptionButton(iconId = R.drawable.gg_icon, text = "GOOGLE") {

        }
    }
}

@Composable
fun OtherOptionButton(@DrawableRes iconId: Int, text: String, onclick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 20.dp)
            .clip(RoundedCornerShape(35.dp))
            .background(Color(0xFFFEFEFE))
            .clickable {
                onclick
            }
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = text,
            modifier = Modifier
                .padding(5.dp)
                .size(40.dp)
        )
        Text(
            text = text,
            style = otherAuthOption,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, end = 10.dp)
        )
    }
}