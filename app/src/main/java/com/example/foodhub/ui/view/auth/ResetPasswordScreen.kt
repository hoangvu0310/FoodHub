package com.example.foodhub.ui.view.auth

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.foodhub.ui.components.BackButton
import com.example.foodhub.ui.components.auth.AuthBackground
import com.example.foodhub.ui.theme.appOrange
import com.example.foodhub.ui.theme.authOptionStyle
import com.example.foodhub.ui.theme.authTitleStyle
import com.example.foodhub.ui.theme.inputAuthStyle
import com.example.foodhub.ui.theme.placeholderAuthStyle
import com.example.foodhub.ui.theme.subTitleStyle
import com.example.foodhub.ui.theme.unfocusedTextField

@Composable
fun ResetPassWordScreen() {
    var emailField by remember {
        mutableStateOf("")
    }
    var isEmpty by remember {
        mutableStateOf(true)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        AuthBackground()

        BackButton {
            //TODO: back to Login
        }

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(30.dp)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.size(180.dp))

            Text(
                text = "Reset Password",
                style = authTitleStyle,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Please enter your email address to request a password reset",
                style = subTitleStyle,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.size(30.dp))

            OutlinedTextField(
                value = emailField,
                onValueChange = { inputText -> // Disable user from starting and ending with ' '
                    emailField = inputText.trimStart{it == ' '}.trimEnd {it == ' '}
                    isEmpty = emailField.isBlank()
                },
                placeholder = {
                    Text(
                        text = "Enter your email",
                        style = placeholderAuthStyle
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = appOrange,
                    unfocusedBorderColor = unfocusedTextField
                ),
                shape = RoundedCornerShape(10.dp),
                textStyle = inputAuthStyle,
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.size(40.dp))

            Button(
                colors = ButtonDefaults.buttonColors(appOrange),
                enabled = !isEmpty,
                onClick = {
                    //TODO: reset password and back to login
                }
            ) {
                Text(
                    text = "SEND NEW PASSWORD",
                    style = authOptionStyle,
                    modifier = Modifier.padding(20.dp)
                )
            }
        }
    }
}