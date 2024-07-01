package com.example.foodhub.ui.view.auth

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.foodhub.ui.components.BackButton
import com.example.foodhub.ui.components.auth.AuthBackground
import com.example.foodhub.ui.components.auth.SideOptionText
import com.example.foodhub.ui.theme.appOrange
import com.example.foodhub.ui.theme.authTitleStyle
import com.example.foodhub.ui.theme.otpValueStyle
import com.example.foodhub.ui.theme.subTitleStyle

@Composable
fun VerificationCodeScreen() {
    var emailSent = "prelookstudio@gmail.com"
    var otpValue by remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier.fillMaxSize()) {
        AuthBackground()

        BackButton {
            //TODO: back Sign up
        }

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.size(180.dp))

            Text(
                text = "Verification Code",
                style = authTitleStyle,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Please type the verification code sent to $emailSent",
                style = subTitleStyle,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.size(30.dp))

            // OTP input field
            BasicTextField(
                value = otpValue,
                onValueChange = {
                    if (it.length <= 4) {
                        otpValue = it
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword
                ),
                decorationBox = {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                    ) {
                        repeat(times = 4) { index ->
                            val num = when {
                                index >= otpValue.length -> ""
                                else -> otpValue[index].toString()
                            }
                            val isFocus = index == otpValue.length

                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                                    .border(
                                        width = 2.dp,
                                        shape = RoundedCornerShape(15.dp),
                                        color = if (isFocus) appOrange else Color(0xFFEEEEEE)
                                    )

                            ) {
                                Text(
                                    text = num,
                                    style = otpValueStyle,
                                )
                            }
                        }
                    }
                    
                }
            )
            
            Spacer(modifier = Modifier.size(15.dp))
            
            SideOptionText(
                message = "I don't receive a code! ",
                option = "Please resend"
            ) {
                // TODO: Resend code
            }
        }
    }
}