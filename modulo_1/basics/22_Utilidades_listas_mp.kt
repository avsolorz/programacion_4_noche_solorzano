fun main() {
    println("Utilidades de Listas")
    val presupuestos = listOf(1000.0, 2500.0, 500.0, 8000.0, 3200.0, 750.0, 12000.0, 450.0, 5000.0, 620.0)
    println(presupuestos)

    // MAP: Transforma cada elemento de la lista
    val presupuestosConIva = presupuestos.map { it * 1.13 }
    println(presupuestosConIva)

    val presupuestosTexto = presupuestos.map { "Presupuesto: $$it" }
    println(presupuestosTexto)

    println("Filter")

    // FILTER: Selecciona solo los elementos que cumplen una condicion
    val eventosGrandes = presupuestos.filter { it > 3000.0 }
    println(eventosGrandes)

    val eventosEconomicos = presupuestos.filter { it < 1000.0 }
    println(eventosEconomicos)

    // Combinando condiciones
    val eventosMedianosGrandes = presupuestos.filter { it > 1000.0 && it <= 8000.0 }
    println(eventosMedianosGrandes)
    val eventosMiniaturos = presupuestos.filterNot { it > 1000.0 }
    println(eventosMiniaturos)
}
