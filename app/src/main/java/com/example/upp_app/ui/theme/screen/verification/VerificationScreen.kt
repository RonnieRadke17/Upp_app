package com.example.upp_app.ui.theme.screen.verification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.upp_app.navigation.Routes

@Composable
fun VerificationScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var code1 by remember { mutableStateOf(TextFieldValue("")) }
    var code2 by remember { mutableStateOf(TextFieldValue("")) }
    var code3 by remember { mutableStateOf(TextFieldValue("")) }
    var code4 by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Título
        Text(
            text = "Verification",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        // Subtítulo
        Text(
            text = "Enter the code sent to your email",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 8.dp, bottom = 32.dp)
        )

        // Campos de código
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CodeField(value = code1, onValueChange = { code1 = it })
            CodeField(value = code2, onValueChange = { code2 = it })
            CodeField(value = code3, onValueChange = { code3 = it })
            CodeField(value = code4, onValueChange = { code4 = it })
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Botón de "Verify"
        Button(
            onClick = {
                // Aquí se implementaría la lógica de verificación.
                // Si es exitosa, navega a la pantalla HOME.
                navController.navigate(Routes.HOME) {
                    popUpTo(Routes.LOGIN) { inclusive = true }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6D4C41))
        ) {
            Text(text = "Verify", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Enlace "Didn't receive the code? Resend"
        Text(
            text = "Didn't receive the code? Resend",
            textDecoration = TextDecoration.Underline,
            color = Color.Gray,
            fontWeight = FontWeight.Light
        )
    }
}

@Composable
fun CodeField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    BasicTextField(
        value = value,
        onValueChange = { newValue ->
            if (newValue.text.length <= 1) {
                onValueChange(newValue)
            }
        },
        modifier = Modifier
            .width(60.dp)
            .height(60.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(12.dp),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF5F5F5), RoundedCornerShape(8.dp))
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                if (value.text.isEmpty()) {
                    Text(
                        text = "0",
                        color = Color.Gray
                    )
                }
                innerTextField()
            }
        }
    )
}
