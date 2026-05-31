package com.ute.compose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun S02TextScreen_mp() {
    Column(
        modifier            = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Sección 2 · Text con estilos — Gestor de Eventos",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        EtiquetaSeccion("1. Texto básico")
        Text("Evento sin propiedades adicionales")

        EtiquetaSeccion("2. fontSize + fontWeight + fontStyle")
        Text("Conferencia Tech 2025",   fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Festival de Música",       fontSize = 18.sp, fontStyle  = FontStyle.Italic)
        Text("Gala Benéfica Anual",      fontSize = 20.sp, fontWeight = FontWeight.Light)

        EtiquetaSeccion("3. Color y decoración")
        Text("Evento activo",
            color = Color(0xFF00796B))
        Text("Fecha confirmada",
            textDecoration = TextDecoration.Underline)
        Text("Evento cancelado",
            textDecoration = TextDecoration.LineThrough,
            color          = MaterialTheme.colorScheme.onSurfaceVariant)

        EtiquetaSeccion("4. maxLines + TextOverflow")
        Text(
            text     = "Conferencia Internacional de Tecnología e Innovación para Emprendedores del Siglo XXI",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text     = "El evento contará con ponentes internacionales, workshops prácticos, zonas de networking y exposición de proyectos innovadores",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        EtiquetaSeccion("5. Escala tipográfica Material 3")
        Text("headlineMedium", style = MaterialTheme.typography.headlineMedium)
        Text("titleLarge",     style = MaterialTheme.typography.titleLarge)
        Text("bodyLarge",      style = MaterialTheme.typography.bodyLarge)
        Text("bodySmall",      style = MaterialTheme.typography.bodySmall)
        Text("labelSmall",     style = MaterialTheme.typography.labelSmall)

        EtiquetaSeccion("6. TextAlign")
        Text(
            text      = "Nombre del evento centrado en todo el ancho disponible",
            textAlign = TextAlign.Center,
            modifier  = Modifier.fillMaxWidth()
        )
        Text(
            text      = "Presupuesto: \$15,000",
            textAlign = TextAlign.End,
            modifier  = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun S02Preview_mp() {
    MaterialTheme { S02TextScreen_mp() }
}
