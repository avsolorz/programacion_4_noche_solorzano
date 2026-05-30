class Presupuesto(val montoBase: Double, val montoReserva: Double) {
    val total:    Double get() = montoBase + montoReserva
    val margen:   Double get() = 2 * (montoBase + montoReserva)

    // Siempre llaman al constructor primario con this(...)
    constructor(monto: Double) : this(monto, monto * 0.10)
    constructor(montoBase: Int, montoReserva: Int) : this(montoBase.toDouble(), montoReserva.toDouble())

    override fun toString() = "Presupuesto(base=${montoBase} reserva=${montoReserva}) | total=${total}"
}

fun main() {
    val p1 = Presupuesto(8000.0, 800.0)
    val p2 = Presupuesto(5000.0)       // reserva automatica 10%
    val p3 = Presupuesto(3000, 300)    // con Int

    println(p1)
    println(p2)
}
