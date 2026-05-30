fun main() {
    println("If con condiciones anidadas")
    println("El evento tiene sede confirmada? s/n")

    val tieneSede = readLine()?.trim()?.lowercase() == "s"
    println("Numero de participantes esperados:")

    val participantes = readLine()?.toIntOrNull() ?: 0
    if (tieneSede){
        println("Evento con sede confirmada")
        if (participantes > 1000){
            println("Requiere personal de seguridad adicional")
        } else {
            println("Personal de seguridad estandar suficiente")
        }
    } else {
        println("Evento sin sede confirmada")
        if (participantes < 50 || participantes > 500){
            println("Buscar sede adecuada al aforo requerido")
        } else {
            println("Buscar sala de conferencias disponible")
        }
    }
}



