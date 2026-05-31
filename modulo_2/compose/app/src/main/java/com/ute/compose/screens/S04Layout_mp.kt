package com.ute.compose.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun S04LayoutScreen_mp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),  // scroll para ver todo el contenido
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("Sección 4 · Column · Row · Box — Gestor de Eventos",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        // ── COLUMN ─────────────────────────────────────────────────────────
        EtiquetaSeccion("Column — fases del evento apiladas verticalmente")
        Column(
            modifier            = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE0F2F1))
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CeldaLayout("Planificación", Color(0xFF80CBC4))
            CeldaLayout("Organización",  Color(0xFF4DB6AC))
            CeldaLayout("Ejecución",     Color(0xFF26A69A))
        }

        // ── ROW con Arrangement ────────────────────────────────────────────
        EtiquetaSeccion("Row — SpaceBetween: resumen de evento")
        Row(
            modifier              = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFF8E1))
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment     = Alignment.CenterVertically
        ) {
            Text("Participantes")
            Text("Venue")
            Text("Presupuesto")
        }

        EtiquetaSeccion("Row — SpaceEvenly: categorías de eventos")
        Row(
            modifier              = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE8F5E9))
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("Corporativo"); Text("Social"); Text("Cultural"); Text("Deportivo")
        }

        // ── ROW con weight ─────────────────────────────────────────────────
        EtiquetaSeccion("Row + weight: distribución del presupuesto (Venue 1x · Catering 2x · Logística 1x)")
        Row(Modifier.fillMaxWidth().height(50.dp)) {
            Box(Modifier.weight(1f).fillMaxHeight().background(Color(0xFFFFCDD2)),
                contentAlignment = Alignment.Center) { Text("Venue") }
            Box(Modifier.weight(2f).fillMaxHeight().background(Color(0xFFEF9A9A)),
                contentAlignment = Alignment.Center) { Text("Catering") }
            Box(Modifier.weight(1f).fillMaxHeight().background(Color(0xFFEF5350)),
                contentAlignment = Alignment.Center) { Text("Logística") }
        }

        // ── BOX ────────────────────────────────────────────────────────────
        EtiquetaSeccion("Box — banner del evento con capas superpuestas")
        Box(
            modifier         = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Color(0xFF004D40)),
            contentAlignment = Alignment.Center   // alineación por defecto
        ) {
            // Capa 1: esquina superior izquierda — estado del evento
            Box(Modifier.size(40.dp).background(Color(0xFF26A69A))
                .align(Alignment.TopStart))
            // Capa 2: esquina inferior derecha — logo del organizador
            Box(Modifier.size(40.dp).background(Color(0xFF00796B))
                .align(Alignment.BottomEnd))
            // Capa 3: centrada — nombre del evento
            Text("Conferencia Tech 2025",
                color = Color.White,
                style = MaterialTheme.typography.labelLarge)
        }
    }
}

@Composable
private fun CeldaLayout(label: String, color: Color) {
    Box(
        modifier         = Modifier.fillMaxWidth().height(36.dp).background(color),
        contentAlignment = Alignment.Center
    ) { Text(label, style = MaterialTheme.typography.labelMedium) }
}

@Preview(showBackground = true)
@Composable
fun S04Preview_mp() {
    MaterialTheme { S04LayoutScreen_mp() }
}
