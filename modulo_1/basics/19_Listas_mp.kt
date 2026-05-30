fun main (){
    println("Listas")
    println("")
    val tareas = listOf("Reservar sede", "Contratar catering", "Disenar material", "Enviar invitaciones", "Configurar registro")
    println(tareas)
    println("Size: ${tareas.size}")
    println("Mostrar el elemento indice 0: ${tareas[0]}")
    println("Mostrar el primer elemento: ${tareas.first()}")
    println("Mostrar ultimo elemento: ${tareas.last()}")

    println("Mostrar el elemento indice 2: ${tareas.get(2)}")
    println("Mostrar contenido segun indice ${tareas.indexOf("Contratar catering")}")
    println("Verificar existencia de un elemento: ${tareas.contains("Enviar invitaciones")}")
    println("Verificar existencia de un elemento: ${"Publicidad" in tareas}")


    //Sublista
    println("Sublista: ${tareas.subList(1,4)}")
    println("Tomar primero 2 elementos: ${tareas.take(2)}")
    println("Suprimir tres primeros elementos ${tareas.drop(3)}")
    println("Tomar ultimos dos elementos: ${tareas.takeLast(2)}")
    println(tareas)

    println("Mutables")
    val participantes = mutableListOf("Ana Garcia", "Luis Perez", "Maria Torres", "Carlos Ruiz")
    println(participantes)
    participantes.add("Sofia Mendez")
    println(participantes)
    participantes.add(0, "Roberto Diaz")
    println(participantes)
    participantes.remove("Luis Perez")
    participantes[1] = "Andrea Lopez"
    println(participantes)


    println("Array deque")
    val colaEspera = ArrayDeque<String>()
    println(colaEspera)
    colaEspera.addFirst("Participante A")
    println(colaEspera)
    colaEspera.addFirst("Participante B")
    println(colaEspera)
    colaEspera.addLast("Participante C")
    println(colaEspera)
    colaEspera.removeFirst()
    println(colaEspera)
    colaEspera.removeLast()
    println(colaEspera)

}
