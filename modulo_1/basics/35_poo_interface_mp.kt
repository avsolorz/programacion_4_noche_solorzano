interface Serializable {
    val id: String                    // abstracta — debe implementarse
    fun serializar(): String          // abstracta — debe implementarse
    val version: Int get() = 1        // con default — puede sobreescribirse
}

interface Validable {
    val errores: List<String>
    val esValido: Boolean get() = errores.isEmpty()

    fun validar(): Boolean
    fun imprimirErrores() {                // implementación por defecto
        if (errores.isEmpty()) println("Sin errores")
        else errores.forEach { println("  ❌ $it") }
    }
}

// POLIMORFISMO: RegistroEvento puede usarse donde se espere Serializable O Validable
data class RegistroEvento(
    override val id: String,
    val organizador: String,
    val actividades: List<String>,
    val presupuesto: Double
) : Serializable, Validable {

    override fun serializar() =
        "$id|$organizador|${actividades.joinToString(",")}|$presupuesto"

    override val errores: List<String> get() = buildList {
        if (organizador.isBlank()) add("El organizador no puede estar vacío")
        if (actividades.isEmpty()) add("El evento debe tener al menos una actividad")
        if (presupuesto <= 0)      add("El presupuesto debe ser mayor que cero")
    }

    override fun validar() = esValido
}

fun main() {
    val r1 = RegistroEvento("E001", "Maria Solorzano", listOf("Conferencia", "Taller"), 12500.0)
    val r2 = RegistroEvento("E002", "",                emptyList(),                    -100.0)

    // Polimorfismo por interfaz
    fun procesarSerializable(s: Serializable) = println("→ ${s.serializar()}")
    fun procesarValidable(v: Validable) {
        println("Válido: ${v.esValido}")
        v.imprimirErrores()
    }

    procesarSerializable(r1)   // → E001|Maria Solorzano|Conferencia,Taller|12500.0
    procesarValidable(r1)      // Válido: true / Sin errores
    procesarValidable(r2)      // Válido: false / ❌ ...
}
