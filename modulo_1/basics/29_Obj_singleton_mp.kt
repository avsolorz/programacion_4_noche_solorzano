object ConfiguracionSistema {
    val host:    String = "api.gestoreventos.com"
    val puerto:  Int    = 443
    private val apiKey: String = "ge-secreto-456"   // privado — nunca expuesto

    fun baseUrl() = "https://$host:$puerto"
    fun headers() = mapOf("Authorization" to "Bearer $apiKey")
}

class Organizador private constructor(val id: Int, val nombre: String) {
    companion object {
        private var contadorId = 0

        // Factory function — encapsulamiento del constructor
        fun crear(nombre: String, email: String): Organizador? {
            if (nombre.isBlank() || !email.contains("@")) return null
            return Organizador(++contadorId, nombre.trim())
        }

        const val ROL_DEFECTO = "coordinador"
    }
}

fun main() {
    println(ConfiguracionSistema.baseUrl())  // https://api.gestoreventos.com:443

    val o = Organizador.crear("Maria Solorzano", "maria@eventos.com")
    println(o)
}
