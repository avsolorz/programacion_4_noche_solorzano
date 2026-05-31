package com.ute.compose.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun S03ButtonScreen_mp() {
    // Estado para mostrar cuál acción fue ejecutada
    var ultimaAccion by remember { mutableStateOf("(ninguna)") }

    Column(
        modifier            = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Sección 3 · Variantes de Button — Gestor de Eventos",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        // Panel de feedback — muestra la última acción
        Surface(
            color    = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text     = "Última acción: $ultimaAccion",
                modifier = Modifier.padding(12.dp),
                style    = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(Modifier.height(4.dp))

        Button(
            onClick  = { ultimaAccion = "Crear Evento (Primary)" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Crear Evento — Primary") }

        // Button con ícono dentro del slot de contenido
        Button(
            onClick  = { ultimaAccion = "Agregar participante" },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector        = Icons.Default.Add,
                contentDescription = null,
                modifier           = Modifier.size(18.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text("Agregar participante")
        }

        OutlinedButton(
            onClick  = { ultimaAccion = "Ver detalles del evento" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Ver detalles — OutlinedButton") }

        TextButton(
            onClick  = { ultimaAccion = "Cancelar acción" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Cancelar — TextButton") }

        ElevatedButton(
            onClick  = { ultimaAccion = "Publicar evento" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Publicar Evento — ElevatedButton") }

        FilledTonalButton(
            onClick  = { ultimaAccion = "Guardar borrador" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Guardar Borrador — FilledTonalButton") }

        // enabled = false → el botón no dispara onClick, apariencia atenuada
        Button(
            onClick  = { },
            enabled  = false,
            modifier = Modifier.fillMaxWidth()
        ) { Text("Evento cerrado (enabled = false)") }

        HorizontalDivider()

        // IconButton — solo ícono, sin texto
        EtiquetaSeccion("IconButton")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            IconButton(onClick = { ultimaAccion = "IconButton Nuevo evento" }) {
                Icon(Icons.Default.Add, contentDescription = "Nuevo evento")
            }
            IconButton(onClick = { ultimaAccion = "IconButton Eliminar evento" }) {
                Icon(Icons.Default.Delete, contentDescription = "Eliminar evento",
                    tint = MaterialTheme.colorScheme.error)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun S03Preview_mp() {
    MaterialTheme { S03ButtonScreen_mp() }
}
