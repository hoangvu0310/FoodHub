package com.example.foodhub.ui.components.welcome

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodhub.R
import com.example.foodhub.ui.theme.appOrange
import com.example.foodhub.ui.theme.sofiaPro
import com.example.foodhub.ui.theme.startSignUpText
import com.example.foodhub.ui.theme.welcomeDescription

@Composable
fun WelcomeScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome_background),
            contentDescription = "Welcome Background",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize()
        )
        
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonColors(
                    containerColor = Color.White,
                    contentColor = appOrange,
                    disabledContentColor = appOrange,
                    disabledContainerColor = Color.White
                ),
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    text = "Skip", style = TextStyle(
                        fontFamily = sofiaPro,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp
                    )
                )
            }
            
            Spacer(modifier = Modifier.size(70.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontSize = 60.sp,
                            fontFamily = sofiaPro,
                            fontWeight = FontWeight.Bold,
                        )
                    ) {
                        append("Welcome to\n")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = appOrange,
                            fontSize = 60.sp,
                            fontFamily = sofiaPro,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                    append("FoodHub")
                    }
                },
                lineHeight = 64.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
            
            Text(
                text = "Your favorite food delivered\nfast at your door",
                style = welcomeDescription,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.size(240.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Canvas(modifier = Modifier.weight(0.3f)) {
                    val canvasWidth = size.width

                    drawLine(
                        color = Color.White,
                        start = Offset(x = 0f, y = 0f),
                        end = Offset(x = canvasWidth, y = 0f),
                        alpha = 0.5f,
                        strokeWidth = 7f
                    )
                }
                Text(
                    text = "sign in with",
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = sofiaPro,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Canvas(modifier = Modifier.weight(0.3f)) {
                    val canvasWidth = size.width

                    drawLine(
                        color = Color.White,
                        start = Offset(x = 0f, y = 0f),
                        end = Offset(x = canvasWidth, y = 0f),
                        alpha = 0.5f,
                        strokeWidth = 7f
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                LogInOptionButton(iconId = R.drawable.fb_icon, text = "FACEBOOK") {

                }
                LogInOptionButton(iconId = R.drawable.gg_icon, text = "GOOGLE") {

                }
            }

            OutlinedButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.elevatedButtonColors(Color.Transparent),
                border = BorderStroke(2.dp, Color.White),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()

            ) {
                Text(
                    text = "Start with email or phone",
                    style = TextStyle(
                        color = startSignUpText,
                        fontFamily = sofiaPro,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }

            Row(
                modifier = Modifier.padding(top = 20.dp)
            ) {
                Text(
                    text = "Already have an account? ",
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = sofiaPro,
                        fontWeight = FontWeight.Normal,
                        fontSize = 17.sp
                    )
                )
                Text(
                    text = "Sign in",
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = sofiaPro,
                        fontWeight = FontWeight.Medium,
                        fontSize = 17.sp,
                    ),
                    modifier = Modifier
                        .drawBehind { //Draw on the bottom of component
                            val borderSize = 1.dp
                            drawLine(
                                color = Color.White,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = borderSize.toPx()
                            )
                        }
                        .clickable {

                        }
                )
            }
        }
    }
}

@Composable
fun LogInOptionButton(@DrawableRes iconId: Int, text: String, onclick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 20.dp)
            .clip(RoundedCornerShape(35.dp))
            .background(Color.White)
            .width(160.dp)
            .height(60.dp)
            .clickable {
                onclick
            }
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = text,
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .size(35.dp)
        )
        Text(
            text = text,
            style = TextStyle(
                color = Color.Black,
                fontFamily = sofiaPro,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                letterSpacing = 0.5.sp
            ),
            textAlign = TextAlign.Center,
        )
    }
}