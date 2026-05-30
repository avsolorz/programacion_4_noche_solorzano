fun main() {
    println ("If con multiples condiciones")
    val inscritos = readLine()?.toIntOrNull() ?: 0
    val estadoEvento = if(inscritos <= 0){
        "Sin inscritos"
    } else if (inscritos <= 50){
        "Evento pequeño"
    } else if (inscritos <= 200){
        "Evento mediano"
    } else if (inscritos <= 500){
        "Evento grande"
    } else {
        "Evento masivo"
    }
    println("Clasificacion: $estadoEvento")
}
