package com.example.projetoe_cir.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RegisterScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Nome Completo") },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )
        Button(
            onClick = { navController.navigate("login") },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Cadastrar")
        }
    }
}
