class Cronograma(val diasPreparacion: Double, val diasEvento: Double) {
    val totalDias:    Double get() = diasPreparacion + diasEvento
    val semanas:      Double get() = totalDias / 7

    // Siempre llaman al constructor primario con this(...)
    constructor(dias: Double) : this(dias, dias)
    constructor(diasPreparacion: Int, diasEvento: Int) : this(diasPreparacion.toDouble(), diasEvento.toDouble())

    override fun toString() = "Cronograma(${diasPreparacion} prep x ${diasEvento} evento) | total=${totalDias} dias"
}

fun main() {
    val c1 = Cronograma(30.0, 3.0)
    val c2 = Cronograma(14.0)        // preparacion igual a duracion
    val c3 = Cronograma(60, 5)       // con Int

    println(c1)
    println(c2)
}
