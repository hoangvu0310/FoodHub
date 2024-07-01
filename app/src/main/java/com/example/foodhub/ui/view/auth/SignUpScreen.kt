package com.example.foodhub.ui.view.auth

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
import com.example.foodhub.ui.components.auth.AuthBackground
import com.example.foodhub.ui.components.auth.AuthenticationOptionGroup
import com.example.foodhub.ui.theme.appOrange
import com.example.foodhub.ui.theme.authLabel
import com.example.foodhub.ui.theme.authTitle
import com.example.foodhub.ui.theme.inputAuth
import com.example.foodhub.ui.theme.passwordButton
import com.example.foodhub.ui.theme.placeholderAuth
import com.example.foodhub.ui.theme.unfocusedTextField


@Composable
fun SignUpScreen() {
    var nameFieldState by remember {
        mutableStateOf("")
    }
    var emailFieldState by remember {
        mutableStateOf("")
    }
    var passwordFieldState by remember {
        mutableStateOf("")
    }
    var showPassword by remember {
        mutableStateOf(false)
    }
    var isEmptyFields by remember {
        mutableStateOf(true)
    }

    Box {
        AuthBackground()

        Column ( // Input text fields
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 20.dp)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.size(100.dp))

            //Text field
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Sign up",
                    style = authTitle,
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                        .fillMaxWidth()
                )

                // Full name field
                Text(
                    text = "Full name",
                    style = authLabel,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                )
                OutlinedTextField(
                    value = nameFieldState,
                    onValueChange = { inputText ->  // Disable user from starting and ending with ' '
                        nameFieldState = inputText.trimStart{it == ' '}.trimEnd{it == ' '}

                        isEmptyFields = !(nameFieldState.isNotBlank()   // Check if fields are empty
                                && emailFieldState.isNotBlank()
                                && passwordFieldState.isNotBlank()
                                )
                    },

                    textStyle = inputAuth,
                    placeholder = {
                        Text(
                            text = "Your full name",
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

                // Email field
                Text(
                    text = "E-mail",
                    style = authLabel,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                )
                OutlinedTextField(
                    value = emailFieldState,
                    onValueChange = { inputText ->  // Disable user from starting and ending with ' '
                        emailFieldState = inputText.trimStart{it == ' '}.trimEnd {it == ' '}

                        isEmptyFields = !(nameFieldState.isNotBlank()   // Check if fields are empty
                                && emailFieldState.isNotBlank()
                                && passwordFieldState.isNotBlank()
                                )
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
                    value = passwordFieldState,
                    onValueChange = {
                        passwordFieldState = it
                        isEmptyFields = !(nameFieldState.isNotBlank()   // Check if fields are empty
                                && emailFieldState.isNotBlank()
                                && passwordFieldState.isNotBlank()
                                )
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
                        .padding(bottom = 40.dp)
                )
            }

            AuthenticationOptionGroup(
                mainOption = "SIGN UP",
                sideText = "Already have an account? ",
                sideOption = "Login",
                otherOptionText = "Sign up with",
                isEmptyFields = isEmptyFields
            )
        }
    }
}