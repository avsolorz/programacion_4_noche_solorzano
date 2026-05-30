// Definición de la clase Evento
class Evento(
    val id: Int,
    val nombre: String,
    val presupuesto: Double,
    val participantes: Int
) {
    // Método que devuelve true si hay participantes registrados
    fun activo(): Boolean = participantes > 0

    // Propiedad calculada: presupuesto con IVA (13%)
    val presupuestoConIva: Double
        get() = presupuesto * 1.13

    // Representación en texto
    override fun toString(): String = "$nombre ($${String.format("%.2f", presupuesto)})"
}

// Función principal
fun main() {
    println("Programación Orientada a Objeto")
    println("Abstraccion")

    val conferencia = Evento(1, "Conferencia Tech", 8500.00, 200)
    println(conferencia)
    println(conferencia.activo())
    println(conferencia.presupuestoConIva)

    val taller = Evento(2, "Taller de Innovacion", 2500.00, 0)
    println(taller.activo())
    println(taller.presupuestoConIva)

    println("Encapsulamiento")
    println("Herencia")
}
