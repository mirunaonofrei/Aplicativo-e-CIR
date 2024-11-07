package com.example.projetoe_cir.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.border
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.projetoe_cir.AnchorLogo

@Composable
fun LoginScreen(navController: NavController) {
    // Credenciais predefinidas
    val correctUsername = "admin"
    val correctPassword = "1234"

    // Estado para armazenar os valores inseridos
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NavyBlue)
            .padding(16.dp), // Adiciona padding para a tela não ir até as bordas
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Para centralizar a logo e o formulário na tela
    ) {
        // Logo centralizada
        AnchorLogo()

        Spacer(modifier = Modifier.height(32.dp)) // Espaço entre a logo e o formulário

        // Container com borda
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f) // Limita a largura do container para 80% da tela
                .background(Color.White) // Preenchendo com fundo branco
                .border(2.dp, Color.Gray, shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp)) // Borda com cantos arredondados
                .padding(16.dp) // Espaçamento interno
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Campo de Usuário
                TextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    modifier = Modifier.fillMaxWidth()
                )

                // Campo de Senha
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Senha") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                // Exibindo mensagem de erro
                if (loginError) {
                    Text(
                        text = "Usuário ou senha incorretos!",
                        color = Color.Red,
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                // Botão de Login
                Button(
                    onClick = {
                        if (username == correctUsername && password == correctPassword) {
                            navController.navigate("home")
                        } else {
                            loginError = true
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Login")
                }

                // Link para cadastro
                TextButton(onClick = { navController.navigate("register") }) {
                    Text("Primeira vez aqui? Cadastre-se!")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ProjetoECIRTheme {
        LoginScreen(rememberNavController())  // Chame a função que representa a tela de login
    }
}
