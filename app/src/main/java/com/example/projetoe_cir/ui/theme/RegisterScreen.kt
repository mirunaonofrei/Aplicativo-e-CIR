package com.example.projetoe_cir.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RegisterScreen(navController: NavController) {
    // Crie variáveis de estado para armazenar o valor digitado em cada campo
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Campo para o Nome Completo
        TextField(
            value = fullName,
            onValueChange = { fullName = it }, // Atualiza o valor conforme o usuário digita
            label = { Text("Nome Completo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        // Campo para o Email
        TextField(
            value = email,
            onValueChange = { email = it }, // Atualiza o valor conforme o usuário digita
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        // Campo para a Senha
        TextField(
            value = password,
            onValueChange = { password = it }, // Atualiza o valor conforme o usuário digita
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation(), // Oculta o texto para senhas
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        // Botão de Cadastro
        Button(
            onClick = {
                // Ação de navegação para a tela de login
                navController.navigate("login")
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Cadastrar")
        }
    }
}
