package com.ute.compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun S05ModifierScreen_mp() {
    var ultimaSeleccion by remember { mutableStateOf("Selecciona un elemento") }

    Column(
        modifier            = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Sección 5 · Modifier — Gestor de Eventos",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        // Panel de feedback
        Surface(
            color    = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(ultimaSeleccion, Modifier.padding(12.dp),
                style = MaterialTheme.typography.bodySmall)
        }

        EtiquetaSeccion("1. clip ANTES de background (correcto)")
        Box(
            modifier = Modifier
                .size(130.dp)
                .clip(RoundedCornerShape(16.dp))                        // 1° recorta
                .background(MaterialTheme.colorScheme.primaryContainer)  // 2° pinta dentro
                .border(2.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(16.dp))
                .padding(12.dp)
                .clickable { ultimaSeleccion = "Tarjeta de evento ✅" },
            contentAlignment = Alignment.Center
        ) {
            Text("clip\nantes de\nbackground ✅",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer)
        }

        EtiquetaSeccion("2. background ANTES de clip (error común)")
        Box(
            modifier = Modifier
                .size(130.dp)
                .background(Color(0xFFFFCDD2))    // 1° pinta (sin recorte aún)
                .clip(RoundedCornerShape(16.dp))  // 2° recorta — tarde para el fondo
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("background\nantes de\nclip ❌",
                style = MaterialTheme.typography.labelSmall)
        }

        EtiquetaSeccion("3. CircleShape + clickable — avatares de organizadores")
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            listOf("Ana" to Color(0xFF00796B), "Luis" to Color(0xFF388E3C), "María" to Color(0xFFF57C00))
                .forEach { (nombre, color) ->
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(CircleShape)
                            .background(color)
                            .clickable { ultimaSeleccion = "Organizador: $nombre" },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(nombre.first().toString(), color = Color.White,
                            style = MaterialTheme.typography.titleMedium)
                    }
                }
        }

        EtiquetaSeccion("4. fillMaxWidth + padding asimétrico — banner de evento")
        Text(
            text     = "horizontal: 32dp, vertical: 8dp — Conferencia Tech 2025",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE0F2F1))
                .padding(horizontal = 32.dp, vertical = 8.dp)
        )

        EtiquetaSeccion("5. size fijo vs fillMaxWidth — logo vs título")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(Modifier.size(60.dp).background(Color(0xFFB2DFDB)),
                contentAlignment = Alignment.Center) { Text("Logo") }
            Box(Modifier.weight(1f).height(60.dp).background(Color(0xFF80CBC4)),
                contentAlignment = Alignment.Center) { Text("Nombre del Evento") }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun S05Preview_mp() {
    MaterialTheme { S05ModifierScreen_mp() }
}
