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
import com.example.projetoe_cir.ui.theme.RegisterScreen
import com.example.projetoe_cir.ui.theme.LoginScreen
import com.example.projetoe_cir.ui.theme.HomeScreen
import com.example.projetoe_cir.ui.theme.MenuScreen

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
fun AnchorLogo(modifier: Modifier = Modifier) {
    val logoImage = painterResource(R.drawable.logoecir) // Substitua pelo nome correto da imagem

    Image(
        painter = logoImage,
        contentDescription = null,
        modifier = modifier
            .size(200.dp) // Ajuste o tamanho conforme necessário
            .padding(top = 1.dp) // Alinha com espaçamento no topo e embaixo
    )
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


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProjetoECIRTheme {
        MenuScreen(rememberNavController())
    }
}
