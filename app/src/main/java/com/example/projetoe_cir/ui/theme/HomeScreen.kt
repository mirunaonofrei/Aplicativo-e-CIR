package com.example.projetoe_cir.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.projetoe_cir.R

@Composable
fun TopMenu(navController: NavController) {
    IconButton(onClick = { navController.navigate("menutop") }) {
        Icon(
            painter = painterResource(id = R.drawable.icons8_card_pio_50), // Certifique-se de ter o ícone "menu" na pasta de recursos.
            contentDescription = "Menu",
            tint = Color(0xFFC49A6C), // Cor do ícone do menu
            modifier = Modifier.size(32.dp) // Aumente o tamanho do ícone do menu
        )
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(NavyBlue) // Fundo Navy Blue
    ) {
        // Menu superior esquerdo
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            TopMenu(navController)
        }

        // Conteúdo centralizado
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logoecir), // Certifique-se de ter o ícone de âncora na pasta de recursos.
                contentDescription = "Logo",
                modifier = Modifier.size(200.dp) // Aumente o tamanho da imagem da logo
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Botões organizados em grade 2x2 com divisórias
            Column(
                modifier = Modifier
                    .width(300.dp) // Ajuste o valor conforme necessário
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp) // Ajuste a altura dos quadrantes
                ) {
                    HomeButton("Dados Pessoais", R.drawable.icons8_identidade_50__1_) {
                        navController.navigate("profile")
                    }
                    Divider(
                        color = Color(0xFFC49A6C),
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp)
                    )
                    HomeButton("Certificados & Documentos", R.drawable.icons8_documentos_48) {
                        navController.navigate("documents")
                    }
                }
                Divider(
                    color = Color(0xFFC49A6C),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp) // Ajuste a altura dos quadrantes
                ) {
                    HomeButton("Registro Embarques", R.drawable.icons8_passaporte_50) {
                        navController.navigate("boarding")
                    }
                    Divider(
                        color = Color(0xFFC49A6C),
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp)
                    )
                    HomeButton("Calendário Embarques", R.drawable.icons8_calend_rio_32) {
                        navController.navigate("calendar")
                    }
                }
            }
        }
    }
}

@Composable
fun HomeButton(text: String, iconId: Int, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .size(150.dp) // Ajuste o tamanho do quadrante do botão
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = text,
            tint = Color(0xFFC49A6C),
            modifier = Modifier.size(55.dp) // Tamanho do ícone
        )
        Spacer(modifier = Modifier.height(8.dp)) // Espaço entre o ícone e o texto
        Text(
            text = text,
            color = Color.White,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            maxLines = 2 // Permite que o texto quebre em até duas linhas
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}

@Preview(showBackground = true)
@Composable
fun PreviewTopMenu() {
    val navController = rememberNavController()
    TopMenu(navController = navController)
}
