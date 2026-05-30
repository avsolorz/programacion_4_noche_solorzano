fun main() {
    println("When con condiciones")
    println("Numero de participantes del evento")
    val participantes = readLine()?.toIntOrNull() ?: 0

    println("Tiene patrocinador principal? (s/n)")
    val tienePatrocinador = readLine()?.trim()?.lowercase() == "s"

    val nivelPatrocinio = if (tienePatrocinador) {
        println("Nivel de patrocinio (BRONCE, PLATA, ORO)")
        readLine()?.trim()?.uppercase() ?: ""
    } else {
        ""
    }

    val descuento = when {
        !tienePatrocinador && participantes < 50  -> 0.0
        !tienePatrocinador && participantes <= 200 -> 10.0
        !tienePatrocinador && participantes > 200  -> 20.0
        nivelPatrocinio == "BRONCE"               -> 15.0
        nivelPatrocinio == "PLATA"                -> 25.0
        nivelPatrocinio == "ORO"                  -> 40.0
        else                                      -> 5.0
    }

    println("Descuento aplicado al presupuesto: ${"%.2f".format(descuento)}%")
}
