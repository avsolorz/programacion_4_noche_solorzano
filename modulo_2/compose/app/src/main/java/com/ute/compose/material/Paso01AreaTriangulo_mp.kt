// ui/Paso01_TextField.kt
package com.example.compose.material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Paso01AreaTrianguloScreen_mp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("Paso 1 · TextField y OutlinedTextField — Gestor de Eventos",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()
        PresupuestoVenue()
    }
}

// ── Cálculo de presupuesto para venue ────────────────────────────────
@Composable
private fun PresupuestoVenue() {
    var presupuesto      by remember { mutableStateOf("0") }
    var porcentajeVenue  by remember { mutableStateOf("0") }
    var resultado        by remember { mutableStateOf("0") }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Cálculo de Presupuesto para Venue",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary)

        // Presupuesto total del evento
        OutlinedTextField(
            value           = presupuesto,
            onValueChange   = { presupuesto = it },
            label           = { Text("Presupuesto total del evento ($)") },
            leadingIcon     = { Icon(Icons.Default.Person, contentDescription = null) },
            // keyboardOptions configura el teclado del sistema operativo
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        // Porcentaje asignado al venue
        OutlinedTextField(
            value           = porcentajeVenue,
            onValueChange   = { porcentajeVenue = it },
            label           = { Text("Porcentaje asignado al venue (%)") },
            leadingIcon     = { Icon(Icons.Default.Person, contentDescription = null) },
            // keyboardOptions configura el teclado del sistema operativo
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        Button(
            onClick  = {
                val presDouble = presupuesto.toDoubleOrNull() ?: 0.0
                val porcDouble = porcentajeVenue.toDoubleOrNull() ?: 0.0
                resultado = (presDouble * porcDouble / 100).toString()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Calcular")
        }
        Text(text = "Costo venue: $$presupuesto × $porcentajeVenue% / 100 = $$resultado")
    }
}

@Preview(showBackground = true)
@Composable
fun Paso01AreaTrianguloPreview_mp() {
    MaterialTheme { Paso01AreaTrianguloScreen_mp() }
}
