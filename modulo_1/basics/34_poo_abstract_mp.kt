abstract class TareaEvento(val nombre: String) {
    // abstract — las subclases DEBEN implementar esto (herencia forzada)
    abstract val costoEstimado: Double
    abstract val duracionHoras: Double
    abstract fun descripcion(): String

    // concreto — disponible en todas las subclases (reutilización)
    fun comparar(otra: TareaEvento): String = when {
        costoEstimado > otra.costoEstimado -> "$nombre es más costosa que ${otra.nombre}"
        costoEstimado < otra.costoEstimado -> "$nombre es más económica que ${otra.nombre}"
        else                               -> "$nombre y ${otra.nombre} tienen el mismo costo"
    }

    // Polimorfismo: toString usa costoEstimado y descripcion que son polimórficas
    override fun toString() = "${descripcion()} | Costo: ${"%.2f".format(costoEstimado)}"
}

class TareaLogistica(val sede: String) : TareaEvento("Logística") {
    override val costoEstimado: Double get() = 3500.0
    override val duracionHoras: Double get() = 40.0
    override fun descripcion() = "Logística para sede $sede"
}

class TareaMarketing(val canales: Int) : TareaEvento("Marketing") {
    override val costoEstimado: Double get() = canales * 800.0
    override val duracionHoras: Double get() = canales * 8.0
    override fun descripcion() = "Marketing en $canales canales"
}

class TareaPresupuesto(val montoTotal: Double) : TareaEvento("Presupuesto") {
    override val costoEstimado: Double get() = montoTotal * 0.02
    override val duracionHoras: Double get() = 16.0
    override fun descripcion() = "Gestion de presupuesto de $${"%.2f".format(montoTotal)}"
}

fun main() {
    // POLIMORFISMO: la lista acepta cualquier TareaEvento
    val tareas: List<TareaEvento> = listOf(
        TareaLogistica("Centro de Convenciones"),
        TareaMarketing(4),
        TareaPresupuesto(25000.0)
    )

    tareas.forEach { println(it) }  // toString polimórfico

    val mayor = tareas.maxByOrNull { it.costoEstimado }
    println("\nTarea más costosa: ${mayor?.nombre}")

    println(tareas[0].comparar(tareas[1]))
}
