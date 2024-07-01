package com.example.foodhub.ui.view.auth

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.foodhub.R
import com.example.foodhub.ui.components.BackButton
import com.example.foodhub.ui.components.auth.AuthBackground
import com.example.foodhub.ui.components.auth.AuthenticationOptionGroup
import com.example.foodhub.ui.theme.appOrange
import com.example.foodhub.ui.theme.authTextFieldLabelStyle
import com.example.foodhub.ui.theme.authTitleStyle
import com.example.foodhub.ui.theme.clickableOptionStyle
import com.example.foodhub.ui.theme.inputAuthStyle
import com.example.foodhub.ui.theme.passwordButton
import com.example.foodhub.ui.theme.placeholderAuthStyle
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
        AuthBackground()

        BackButton {
            //TODO: back to Sign up
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
                    style = authTitleStyle,
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                        .fillMaxWidth()
                )

                // Email field
                Text(
                    text = "E-mail",
                    style = authTextFieldLabelStyle,
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
                    textStyle = inputAuthStyle,
                    placeholder = {
                        Text(
                            text = "Your email or phone",
                            style = placeholderAuthStyle
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
                    style = authTextFieldLabelStyle,
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
                    textStyle = inputAuthStyle,
                    placeholder = {
                        Text(
                            text = "Password",
                            style = placeholderAuthStyle
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
                style = clickableOptionStyle,
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .clickable {
                        //TODO: to reset password screen
                    }
            )

            AuthenticationOptionGroup(
                mainOption = "LOGIN",
                sideText = "Don't have an account? ",
                sideOption = "Sign Up",
                otherOptionText = "Sign in with",
                isEmptyFields = isEmptyFields,
                authenticateOption = {
                    //TODO: Login
                },
                sideOptionOnclick = {
                    //TODO: to Sign Up screen
                }
            )
        }
    }
}