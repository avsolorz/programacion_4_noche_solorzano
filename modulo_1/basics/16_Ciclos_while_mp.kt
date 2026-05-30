fun main (){
    println("Ciclos while")
    println("While basico")
    var tareasPendientes = 1
    while (tareasPendientes <= 5){
        println("tareasPendientes")
        tareasPendientes++
    }
    tareasPendientes = 1
    do {
        println("tareasPendientes")
        tareasPendientes++
    } while (tareasPendientes <= 5)

    println("brake = continue")
    tareasPendientes = 1
    while (tareasPendientes <= 10){
        tareasPendientes++
        if (tareasPendientes == 3) continue
        if (tareasPendientes == 7) break
        println(tareasPendientes)
}

var input: String
    while (true){
        println("Escribe 'salir' para terminar el registro de tareas")
        input = readLine() ?: ""
        if (input == "salir") break
        println("Tarea registrada: $input")
}
}
