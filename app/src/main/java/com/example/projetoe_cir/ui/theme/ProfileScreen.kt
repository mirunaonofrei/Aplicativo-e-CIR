package com.example.projetoe_cir.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Nº de Inscrição") },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Naturalidade") },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Nacionalidade") },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Data de Nascimento") },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )
        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Voltar")
        }
    }
}
