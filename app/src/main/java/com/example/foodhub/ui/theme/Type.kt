package com.example.foodhub.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.foodhub.R

val sofiaPro = FontFamily(
    listOf(
        Font(R.font.sofia_pro_regular, FontWeight.Normal),
        Font(R.font.sofia_pro_medium, FontWeight.Medium),
        Font(R.font.sofia_pro_semi_bold, FontWeight.SemiBold),
        Font(R.font.sofia_pro_bold, FontWeight.Bold)
    )
)

val helveticaNeue = FontFamily(
    listOf(
        Font(R.font.helvetica_neue_regular, FontWeight.Normal)
    )
)

//Welcome
val welcomeDescription = TextStyle(
    fontSize = 20.sp,
    fontFamily = sofiaPro,
    fontWeight = FontWeight.Normal,
    color = welcomeDescriptionText
)

//Auth
val authTitle = TextStyle(
    color = Color.Black,
    fontFamily = sofiaPro,
    fontWeight = FontWeight.SemiBold,
    fontSize = 50.sp
)
val authLabel = TextStyle(
    color = authTextFieldLabel,
    fontFamily = sofiaPro,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
)
val inputAuth = TextStyle(
    color = inputAuthText,
    fontFamily = sofiaPro,
    fontWeight = FontWeight.Medium,
    fontSize = 17.sp
)
val placeholderAuth = TextStyle(
    color = placeholderAuthText,
    fontFamily = sofiaPro,
    fontWeight = FontWeight.Normal,
    fontSize = 17.sp
)
val authOption = TextStyle(
    color = Color.White,
    fontFamily = sofiaPro,
    fontWeight = FontWeight.Normal,
    fontSize = 15.sp
)
val clickableOption = TextStyle(
    color = appOrange,
    fontFamily = sofiaPro,
    fontWeight = FontWeight.Medium,
    fontSize = 15.sp,
)
val otherAuthOption = TextStyle(
    color = Color.Black,
    fontFamily = sofiaPro,
    fontWeight = FontWeight.Medium,
    fontSize = 15.sp,
    letterSpacing = 0.05.sp
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)