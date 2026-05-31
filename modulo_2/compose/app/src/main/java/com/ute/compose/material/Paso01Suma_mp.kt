// ui/Paso01_TextField.kt
package com.ute.compose.material

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
fun Paso01SumaScreen_mp() {
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
        SumaParticipantes()
    }
}

// ── Suma de participantes de dos eventos ────────────────────────────────
@Composable
private fun SumaParticipantes() {
    var participantes1  by remember { mutableStateOf("0") }
    var participantes2  by remember { mutableStateOf("0") }
    var resultado       by remember { mutableStateOf("0") }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Total de participantes en dos eventos",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary)

        // Participantes del Evento 1
        OutlinedTextField(
            value           = participantes1,
            onValueChange   = { participantes1 = it },
            label           = { Text("Participantes Evento 1") },
            leadingIcon     = { Icon(Icons.Default.Person, contentDescription = null) },
            // keyboardOptions configura el teclado del sistema operativo
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        // Participantes del Evento 2
        OutlinedTextField(
            value           = participantes2,
            onValueChange   = { participantes2 = it },
            label           = { Text("Participantes Evento 2") },
            leadingIcon     = { Icon(Icons.Default.Person, contentDescription = null) },
            // keyboardOptions configura el teclado del sistema operativo
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            singleLine      = true,
            modifier        = Modifier.fillMaxWidth()
        )

        Button(
            onClick  = {
                val p1 = participantes1.toDoubleOrNull() ?: 0.0
                val p2 = participantes2.toDoubleOrNull() ?: 0.0
                resultado = (p1 + p2).toString()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sumar participantes")
        }
        Text("Total: $participantes1 + $participantes2 = $resultado participantes")
    }
}

@Preview(showBackground = true)
@Composable
fun Paso01SumaPreview_mp() {
    MaterialTheme { Paso01SumaScreen_mp() }
}
