package com.ute.compose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BienvenidaEvento(organizador: String) {
    Text(text = "Bienvenido, $organizador!")
}

@Composable
fun S01SaludoScreen_mp() {
    Column(
        modifier            = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Sección 1 · @Composable básico — Gestor de Eventos",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        // El mismo composable, distintos organizadores
        BienvenidaEvento("Ana García")
        BienvenidaEvento("Luis Martínez")
        BienvenidaEvento("Organizador")

        HorizontalDivider()

        EstadoEvento(activo = true)
        EstadoEvento(activo = false)
    }
}

@Composable
private fun EstadoEvento(activo: Boolean) {
    if (activo) {
        Text("✅ activo = true  → Evento en curso")
    } else {
        // Este Text NUNCA aparece activo — el else es solo para claridad
        Text("(activo = false → Evento finalizado o cancelado)",
            color = MaterialTheme.colorScheme.outline)
    }
}

@Preview(showBackground = true)
@Composable
fun S01_Preview_mp() {
    MaterialTheme { S01SaludoScreen_mp() }
}
