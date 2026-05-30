data class CategoriaEvento(val id: Int, val nombre: String)

data class Evento(
    val id:        Int,
    val nombre:    String,
    val presupuesto: Double,
    val participantes: Int,
    val categoria: CategoriaEvento,
    val activo:    Boolean = true
) {
    val disponible: Boolean get() = activo && participantes > 0
    val presupuestoConIva: Double get() = presupuesto * 1.13

    fun aplicarAjuste(porcentaje: Double): Evento {
        require(porcentaje in 0.0..100.0) { "Ajuste debe ser entre 0 y 100" }
        return copy(presupuesto = presupuesto * (1 + porcentaje / 100))
    }
}

object GestorEventos {
    private val categorias = mutableListOf(
        CategoriaEvento(1, "Tecnologia"),
        CategoriaEvento(2, "Cultural"),
        CategoriaEvento(3, "Deportivo")
    )
    private val eventos    = mutableListOf<Evento>()
    private var siguienteId = 1

    fun agregarEvento(nombre: String, presupuesto: Double, participantes: Int, categoriaId: Int): Evento? {
        val categoria = categorias.find { it.id == categoriaId } ?: return null
        val evento    = Evento(siguienteId++, nombre, presupuesto, participantes, categoria)
        eventos.add(evento)
        return evento
    }

    fun listar(): List<Evento>              = eventos.toList()
    fun disponibles(): List<Evento>         = eventos.filter { it.disponible }
    fun porCategoria(id: Int): List<Evento> = eventos.filter { it.categoria.id == id }
    fun buscar(query: String): List<Evento> =
        eventos.filter { it.nombre.contains(query, ignoreCase = true) }
}

fun imprimirEvento(evento: Evento) {
    println("-------------------------------")
    println("ID:           ${evento.id}")
    println("Nombre:       ${evento.nombre}")
    println("Categoría:    ${evento.categoria.nombre}")
    println("Presupuesto:  $${"%.2f".format(evento.presupuesto)}")
    println("Con IVA:      $${"%.2f".format(evento.presupuestoConIva)}")
    println("Participantes:${evento.participantes} personas")
    println("Estado:       ${if (evento.disponible) "Activo ✅" else "Inactivo ❌"}")
    println("-------------------------------")
}

fun main() {
    GestorEventos.agregarEvento("Conferencia Tech",  8500.0, 300, 1)
    GestorEventos.agregarEvento("Hackathon 2025",    4000.0,   0, 1)
    GestorEventos.agregarEvento("Festival de Arte", 15000.0, 500, 2)
    GestorEventos.agregarEvento("Maraton Solidaria",  3000.0, 200, 3)

    println("=== Todos los eventos ===")
    GestorEventos.listar().forEach { imprimirEvento(it) }

    println("\n=== Activos con 10% de ajuste presupuestal ===")
    GestorEventos.disponibles()
        .map { it.aplicarAjuste(10.0) }
        .forEach { imprimirEvento(it) }
}
