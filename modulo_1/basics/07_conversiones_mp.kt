fun main(){
    println("Conversiones")
    println("Entero a numerico")
    val capacidad: Int = 350

    val capacidadDecimal: Double = capacidad.toDouble()
    val capacidadLong: Long = capacidad.toLong()
    val capacidadTexto: String = capacidad.toString()

    println("to Double $capacidadDecimal")
    println("to Long $capacidadLong")
    println("to String $capacidadTexto")

    println("String a numerico")
    val participantes = "1500".toInt()
    val precioEntrada = "49.99".toDouble()

    val invalido = "evento123".toIntOrNull()
    println("invalido")
}
