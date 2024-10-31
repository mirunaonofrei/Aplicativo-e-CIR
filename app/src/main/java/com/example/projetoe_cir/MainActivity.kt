package com.example.projetoe_cir

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projetoe_cir.ui.theme.ProjetoECIRTheme
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoECIRTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { paddingValues ->
                    // Aplicando paddingValues
                    Box(modifier = Modifier.padding(paddingValues)) {
                        AppNavigation(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") { MenuScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
    }
}

@Composable
fun MenuScreen(navController: NavHostController) {
    ImagemFundo(navController) // Chama a função que inclui a imagem de fundo
}

@Composable
fun AnchorLogo(modifier: Modifier = Modifier) {
    val logoImage = painterResource(R.drawable.logoecir) // Substitua pelo nome correto da imagem

    Image(
        painter = logoImage,
        contentDescription = null,
        modifier = modifier
            .size(300.dp) // Ajuste o tamanho conforme necessário
            //.align(Alignment.TopCenter)
            .padding(top = 1.dp) // Alinha com espaçamento no topo e embaixo
    )
}

@Composable
fun ImagemFundo(navController: NavHostController, modifier: Modifier = Modifier) {
    val backgroundImage = painterResource(R.drawable.planodefundomenu)

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = backgroundImage,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo da âncora
            AnchorLogo()

            // Título
            Text(
                text = "e-CIR",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Botão Entrar
            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Entrar")
            }

            // Botão Entrar como Empresa
            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Entrar como Empresa")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Texto de Primeira vez aqui?
            Text(
                text = "Primeira vez aqui?",
                fontSize = 18.sp,
                fontWeight = FontWeight.Thin,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botão Cadastrar-se
            Button(
                onClick = { navController.navigate("register") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Cadastre-se!")
            }
        }
    }
}


@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Profile Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("home") }) {
            Text(text = "Voltar para o Menu")
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Home Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("profile") }) {
            Text(text = "Dados Pessoais")
        }
        Button(onClick = { navController.navigate("profile") }) {
            Text(text = "Certificados e Documentos")
        }
        Button(onClick = { navController.navigate("profile") }) {
            Text(text = "Registro Embarques")
        }
        Button(onClick = { navController.navigate("profile") }) {
            Text(text = "Calendário Embarques")
        }
        Button(onClick = { navController.navigate("menu") }) {
            Text(text = "Sair")
        }
    }
}

@Composable
fun RegisterScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Register Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("login") }) {
            Text(text = "Ir para Login")
        }
    }
}

@Composable
fun LoginScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Login Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("home") }) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("register") }) {
            Text(text = "Register")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProjetoECIRTheme {
        MenuScreen(rememberNavController())
    }
}
