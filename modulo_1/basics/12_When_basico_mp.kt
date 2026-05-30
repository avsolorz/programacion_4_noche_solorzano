fun main() {
    println("Condicional When")
    println("Codigo de tipo de evento? (1-7)")
    println("1->Conferencia")
    println("2->Taller")
    println("3->Concierto")
    println("4->Feria")
    println("5->Hackathon")
    println("6->Seminario")
    println("7->Gala")

    val codigo = readLine()?.toIntOrNull() ?: 0
    val tipoEvento = when(codigo) {
        1 -> "Conferencia"
        2 -> "Taller"
        3 -> "Concierto"
        4 -> "Feria"
        5 -> "Hackathon"
        6 -> "Seminario"
        7 -> "Gala"
        else -> "Tipo de evento no registrado"
    }

    println("Tipo de evento: $tipoEvento")
}
