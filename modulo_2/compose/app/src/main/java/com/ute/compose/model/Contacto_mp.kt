package com.ute.compose.model

data class Evento(
    val id:          Int,
    val nombre:      String,
    val organizador: String,
    val venue:       String,
    val presupuesto: Double,
    val activo:      Boolean = false
)

// Lista de muestra — la usamos en todos los pasos
val eventosDeMuestra = listOf(
    Evento(1, "Conferencia Tech 2025",  "Ana García",    "Centro de Convenciones",  15000.0, activo = true),
    Evento(2, "Festival de Música",     "Luis Martínez", "Parque Central",            8500.0),
    Evento(3, "Gala Benéfica",          "María López",   "Hotel Grand Plaza",        20000.0, activo = true),
    Evento(4, "Hackathon Innovación",   "Carlos Ruiz",   "Campus UTE",                5000.0),
    Evento(5, "Expo Emprendimiento",    "Sofía Torres",  "Centro Comercial Norte",   12000.0),
    Evento(6, "Cumbre de Liderazgo",    "Pedro Mora",    "Auditorio Municipal",       9800.0),
    Evento(7, "Workshop Diseño UX",     "Elena Vega",    "Co-working Creativo",       3500.0, activo = true),
    Evento(8, "Feria de Negocios",      "Diego Paz",     "Recinto Ferial",           18000.0),
)
