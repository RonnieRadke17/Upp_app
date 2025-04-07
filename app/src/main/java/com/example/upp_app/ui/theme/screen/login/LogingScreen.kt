package com.example.upp_app.ui.theme.screen.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.upp_app.R
import com.example.upp_app.model.LoginRequest
import com.example.upp_app.navigation.Routes
import com.example.upp_app.network.RetrofitClient
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavController, modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Sign In",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(
            text = "Hi! Welcome back, you've been missed",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 8.dp, bottom = 32.dp)
        )

        // Email
        Column(
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text("Email", fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(bottom = 4.dp))
            BasicTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(8.dp))
                    .padding(12.dp),
                decorationBox = { innerTextField ->
                    if (email.text.isEmpty()) {
                        Text("example@gmail.com", color = Color.Gray)
                    }
                    innerTextField()
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Password
        Column(
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text("Password", fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(bottom = 4.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(8.dp))
                    .padding(12.dp)
            ) {
                BasicTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth().padding(end = 40.dp),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    decorationBox = { innerTextField ->
                        if (password.text.isEmpty()) {
                            Text("********", color = Color.Gray)
                        }
                        innerTextField()
                    }
                )

                IconButton(
                    onClick = { passwordVisible = !passwordVisible },
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_visibility_off),
                        contentDescription = "Toggle Password Visibility",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Forgot Password?",
            textDecoration = TextDecoration.Underline,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Sign In Button
        Button(
            onClick = {
                scope.launch {
                    try {
                        val request = LoginRequest(email.text, password.text)
                        val response = RetrofitClient.apiService.loginUser(request)

                        if (response.success) {
                            //registro en el localstorage
                            val sharedPref = context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
                            val success = sharedPref.edit().apply {
                                putString("autentificado", "true")
                            }.commit()  // Bloquea hasta que se guarde en disco y devuelve true o false


                            Toast.makeText(context, "✅ Bienvenido ${response.data?.name}", Toast.LENGTH_SHORT).show()
                            navController.navigate(Routes.HOME)
                        } else {
                            Toast.makeText(context, "❌ Credenciales inválidas", Toast.LENGTH_SHORT).show()
                        }

                    } catch (e: Exception) {
                        Toast.makeText(context, "❌ Error: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6D4C41))
        ) {
            Text(text = "Sign In", color = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Or sign in with", color = Color.Gray, modifier = Modifier.padding(vertical = 8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(painter = painterResource(id = R.drawable.ic_google), contentDescription = "Google", modifier = Modifier.size(40.dp))
            Image(painter = painterResource(id = R.drawable.ic_facebook), contentDescription = "Facebook", modifier = Modifier.size(40.dp))
            Image(painter = painterResource(id = R.drawable.ic_apple), contentDescription = "Apple", modifier = Modifier.size(40.dp))
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Don't have an account? Sign Up",
            textDecoration = TextDecoration.Underline,
            color = Color.Gray,
            fontWeight = FontWeight.Light,
            modifier = Modifier.clickable {
                navController.navigate(Routes.REGISTER)
            }
        )
    }
}

