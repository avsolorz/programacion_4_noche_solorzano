fun main (){
    println("Ciclos repeat")
    println("Cuantas evaluaciones de satisfaccion registrar")
    val evaluaciones = readLine()?.toIntOrNull() ?: 3
    var totalPuntaje = 0
    repeat(evaluaciones){ i ->
        println("Evaluacion ${i+1} del evento (puntaje 1-10)")
        val puntaje = readLine()?.toIntOrNull() ?: 0
        totalPuntaje += puntaje
    }
    val promedio = totalPuntaje / evaluaciones
    println("Satisfaccion promedio del evento: $promedio / 10")
    println("Clasificacion: ${
        when{
            promedio < 4  -> "Evento deficiente"
            promedio <= 7 -> "Evento aceptable"
            else          -> "Evento exitoso"
        }
    }")
}
