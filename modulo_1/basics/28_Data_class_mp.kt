data class Evento(
    val id:        Int,
    val nombre:    String,
    val presupuesto: Double,
    val categoria: String,
    val activo:    Boolean = true
)

fun main() {
    val e1 = Evento(1, "Conferencia Tech", 8500.0, "Tecnologia")
    val e2 = Evento(1, "Conferencia Tech", 8500.0, "Tecnologia")
    val e3 = Evento(2, "Festival de Arte", 15000.0, "Cultural")

    // toString() automático
    println(e1)

    // equals() por valor
    println(e1 == e2)   // true
    println(e1 == e3)   // false

    //copy() — nuevo objeto con cambios puntuales
    val reducido  = e1.copy(presupuesto = 6000.0)
    val inactivo  = e1.copy(activo = false)

    // Desestructuración
    val (id, nombre, presupuesto) = e1
    println("$id: $nombre — $$presupuesto")

    // En bucles
    listOf(e1, e3).forEach { (id2, nombre2, presupuesto2) ->
        println("[$id2] $nombre2: $$presupuesto2")
    }
}
