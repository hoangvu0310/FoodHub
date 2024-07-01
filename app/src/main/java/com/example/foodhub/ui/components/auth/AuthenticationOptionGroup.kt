package com.example.foodhub.ui.components.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodhub.R
import com.example.foodhub.ui.theme.appOrange
import com.example.foodhub.ui.theme.authOptionStyle
import com.example.foodhub.ui.theme.clickableOptionStyle
import com.example.foodhub.ui.theme.line
import com.example.foodhub.ui.theme.sideOptionText
import com.example.foodhub.ui.theme.sofiaPro

@Composable
fun AuthenticationOptionGroup(
    mainOption: String,
    sideText: String,
    sideOption: String,
    otherOptionText: String,
    isEmptyFields: Boolean,
    authenticateOption: () -> Unit,
    sideOptionOnclick: () -> Unit
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
        onClick = {
            authenticateOption
        }
    ) {
        Text(
            text = mainOption,
            style = authOptionStyle
        )
    }

    Spacer(modifier = Modifier.size(20.dp))

    SideOptionText(message = sideText, option = sideOption) {
        sideOptionOnclick
    }

    Spacer(modifier = Modifier.size(30.dp))

    OtherOptionTextWithLine(
        text = otherOptionText,
        strokeWidth = 3f,
        lineColor = line,
        style = TextStyle(
            color = sideOptionText,
            fontFamily = sofiaPro,
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp
        ),
    )

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        AuthenticationButton(
            iconId = R.drawable.fb_icon,
            text = "FACEBOOK",
            elevation = 0.5.dp
        ) {
            // TODO authenticate with FB
        }
        AuthenticationButton(
            iconId = R.drawable.gg_icon,
            text = "GOOGLE",
            elevation = 0.5.dp
        ) {
            // TODO authenticate with GG
        }
    }
}