enum class EstadoEvento(val descripcion: String, val esTerminal: Boolean) {
    PLANIFICACION  ("En fase de planificacion",  false),
    EN_PREPARACION ("Preparacion en curso",      false),
    CONFIRMADO     ("Evento confirmado",         false),
    REALIZADO      ("Evento finalizado con exito", true),
    CANCELADO      ("Evento cancelado",          true);

    fun puedeTransicionarA(siguiente: EstadoEvento): Boolean = when (this) {
        PLANIFICACION  -> siguiente == EN_PREPARACION || siguiente == CANCELADO
        EN_PREPARACION -> siguiente == CONFIRMADO     || siguiente == CANCELADO
        CONFIRMADO     -> siguiente == REALIZADO      || siguiente == CANCELADO
        else           -> false
    }
}

fun main() {
    val estado = EstadoEvento.EN_PREPARACION
    println(estado.descripcion)
    println(estado.esTerminal)

    // when exhaustivo — sin else porque el compilador conoce todos los casos
    val icono = when (estado) {
        EstadoEvento.PLANIFICACION  -> "📋"
        EstadoEvento.EN_PREPARACION -> "⚙️"
        EstadoEvento.CONFIRMADO     -> "✅"
        EstadoEvento.REALIZADO      -> "🎉"
        EstadoEvento.CANCELADO      -> "❌"
    }
    println(icono)

    println(estado.puedeTransicionarA(EstadoEvento.CONFIRMADO))  // true
}
