// ui/Paso01_TextField.kt
package com.example.compose.material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Paso01VentaTicketsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        Text(
            text  = "Sistema de Venta de Tickets",
            style = MaterialTheme.typography.titleMedium
        )

        HorizontalDivider()

        VentaTickets()
    }
}

@Composable
private fun VentaTickets() {

    // Variables
    var evento    by remember { mutableStateOf("") }
    var cantidad  by remember { mutableStateOf("") }
    var precio    by remember { mutableStateOf("") }

    var ingresosBrutos  by remember { mutableStateOf(0.0) }
    var comision        by remember { mutableStateOf(0.0) }
    var ingresosNetos   by remember { mutableStateOf(0.0) }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text  = "Registro de venta de tickets",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary
        )

        // Nombre del evento
        OutlinedTextField(
            value         = evento,
            onValueChange = { evento = it },
            label         = { Text("Nombre del evento") },
            leadingIcon   = {
                Icon(Icons.Default.Event, contentDescription = null)
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            modifier   = Modifier.fillMaxWidth()
        )

        // Número de tickets vendidos
        OutlinedTextField(
            value         = cantidad,
            onValueChange = { cantidad = it },
            label         = { Text("Tickets vendidos") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction    = ImeAction.Next
            ),
            singleLine = true,
            modifier   = Modifier.fillMaxWidth()
        )

        // Precio por ticket
        OutlinedTextField(
            value         = precio,
            onValueChange = { precio = it },
            label         = { Text("Precio por ticket ($)") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction    = ImeAction.Done
            ),
            singleLine = true,
            modifier   = Modifier.fillMaxWidth()
        )

        // Botón calcular
        Button(
            onClick = {

                val cantidadInt   = cantidad.toIntOrNull() ?: 0
                val precioDouble  = precio.toDoubleOrNull() ?: 0.0

                // Calcular ingresos brutos
                ingresosBrutos = cantidadInt * precioDouble

                // Aplicar comisión de la plataforma
                comision = when {
                    ingresosBrutos > 500  -> ingresosBrutos * 0.10
                    ingresosBrutos in 100.0..500.0 -> ingresosBrutos * 0.05
                    else -> 0.0
                }

                // Ingresos netos del organizador
                ingresosNetos = ingresosBrutos - comision
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular")
        }

        HorizontalDivider()

        // Resultados
        Text("Evento: $evento")
        Text("Ingresos brutos: \$$ingresosBrutos")
        Text("Comisión plataforma: \$$comision")
        Text("Ingresos netos: \$$ingresosNetos")
    }
}

@Preview(showBackground = true)
@Composable
fun Paso01VentaTicketsPreview() {
    MaterialTheme {
        Paso01VentaTicketsScreen()
    }
}
