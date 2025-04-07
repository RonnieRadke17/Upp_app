package com.example.upp_app.ui.theme.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import com.example.upp_app.ui.theme.Pink80
import com.example.upp_app.ui.theme.DarkTextColor
import com.example.upp_app.R
import com.example.upp_app.ui.theme.PrimaryPink
import com.example.upp_app.ui.theme.components.PrimaryButton
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    0f to PrimaryPink,
                    1f to Pink80
                )
            )
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_wellcome),
            contentDescription = null,
            modifier = Modifier.size(300.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 32.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Welcome to application",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Black,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Get started by creating an account, Kotlin, Jetpack Compose, and Material Design",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 24.dp),
            style = MaterialTheme.typography.titleLarge,
            color = DarkTextColor,
        )
        Spacer(modifier = Modifier.weight(1f))

        PrimaryButton(
            onClick = {},
            text = "NEXT",
            isNavigationArrowVisible = false,
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.DarkGray
            ),
            cornerRadius = 8.dp
        )
    }
}