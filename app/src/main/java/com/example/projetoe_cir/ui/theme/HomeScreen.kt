package com.example.projetoe_cir.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { navController.navigate("profile") },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Dados Pessoais")
        }
        Button(
            onClick = { /* Certificados e Documentos */ },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Certificados & Documentos")
        }
        Button(
            onClick = { /* Registro de Embarques */ },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Registro Embarques")
        }
        Button(
            onClick = { /* Calendário de Embarques */ },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Calendário Embarques")
        }
    }
}
