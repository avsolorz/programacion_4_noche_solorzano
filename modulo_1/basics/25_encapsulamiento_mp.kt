class Organizador(val nombre: String, val email: String) {
    val nombreNormalizado: String
    val dominioEmail: String

    init {
        // Encapsulamiento en acción: validamos antes de construir
        require(nombre.isNotBlank()) { "El nombre no puede estar vacío" }
        require(email.contains("@")) { "Email inválido: $email" }

        nombreNormalizado = nombre.trim().lowercase()
        dominioEmail      = email.substringAfter("@")
    }
}

fun main() {
    val o = Organizador("  Maria Solorzano  ", "maria@eventos.dev")
    println(o.nombreNormalizado)  // maria solorzano
    println(o.dominioEmail)       // eventos.dev

    // Organizador("", "invalido")   // IllegalArgumentException — require falla
}
