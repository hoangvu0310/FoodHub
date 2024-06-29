package com.example.foodhub.ui.components.auth

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.foodhub.R
import com.example.foodhub.ui.theme.appOrange
import com.example.foodhub.ui.theme.authLabel
import com.example.foodhub.ui.theme.authTitle
import com.example.foodhub.ui.theme.circleBeige
import com.example.foodhub.ui.theme.clickableOption
import com.example.foodhub.ui.theme.inputAuth
import com.example.foodhub.ui.theme.passwordButton
import com.example.foodhub.ui.theme.placeholderAuth
import com.example.foodhub.ui.theme.unfocusedTextField

@Composable
fun LogInScreen() {
    var emailState by remember {
        mutableStateOf("")
    }
    var passwordState by remember {
        mutableStateOf("")
    }
    var showPassword by remember {
        mutableStateOf(false)
    }
    var isEmptyFields by remember {
        mutableStateOf(true)
    }

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

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 20.dp)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.size(180.dp))

            // Text field
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Login",
                    style = authTitle,
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                        .fillMaxWidth()
                )

                // Email field
                Text(
                    text = "E-mail",
                    style = authLabel,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                )
                OutlinedTextField(
                    value = emailState,
                    onValueChange = { inputText ->  // Disable user from starting and ending with ' '
                        emailState = inputText.trimStart{it == ' '}.trimEnd {it == ' '}

                        // Check if fields are empty
                        isEmptyFields = !(emailState.isNotBlank() && passwordState.isNotBlank())
                    },
                    textStyle = inputAuth,
                    placeholder = {
                        Text(
                            text = "Your email or phone",
                            style = placeholderAuth
                        )
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = appOrange,
                        unfocusedBorderColor = unfocusedTextField
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp)
                )

                // Password field
                Text(
                    text = "Password",
                    style = authLabel,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                )

                OutlinedTextField(
                    value = passwordState,
                    onValueChange = {
                        passwordState = it

                        // Check if fields are empty
                        isEmptyFields = !(emailState.isNotBlank() && passwordState.isNotBlank())
                    },
                    textStyle = inputAuth,
                    placeholder = {
                        Text(
                            text = "Password",
                            style = placeholderAuth
                        )
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = appOrange,
                        unfocusedBorderColor = unfocusedTextField
                    ),
                    trailingIcon = {
                        if(showPassword) {
                            IconButton(onClick = {showPassword = false}) {
                                Icon(
                                    painter = painterResource(id = R.drawable.password_eye_hide),
                                    contentDescription = "Hide password",
                                    tint = passwordButton
                                )
                            }
                        } else {
                            IconButton(onClick = { showPassword = true}) {
                                Icon(
                                    painter = painterResource(id = R.drawable.password_eye_show),
                                    contentDescription = "Show password",
                                    tint = passwordButton
                                )
                            }
                        }
                    },
                    visualTransformation = (
                            if(showPassword) {
                                VisualTransformation.None
                            } else {
                                PasswordVisualTransformation()
                            }
                            ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 30.dp)
                )
            }

            Text(
                text = "Forgot password?",
                style = clickableOption,
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .clickable {

                    }
            )
            
            AuthenticationOption(
                mainOption = "LOGIN",
                sideText = "Don't have an account? ",
                sideOption = "Sign Up",
                otherOptionText = "Sign in with",
                isEmptyFields = isEmptyFields
            )
        }
    }
}