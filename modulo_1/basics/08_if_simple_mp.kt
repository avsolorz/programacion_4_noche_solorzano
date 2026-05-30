fun main(){
    println("Control de flujo")
    println("if Simple")
    println("Porcentaje de ocupacion del evento (0-100)")
    val ocupacion = readLine()?.toDoubleOrNull() ?: 0.0
    if(ocupacion >= 80){
        println("Evento con alta demanda")
    }
    if(ocupacion >= 100){
        println("Evento con lista de espera activada")
    }

    println("Ocupacion registrada: ${ocupacion}%")
}
