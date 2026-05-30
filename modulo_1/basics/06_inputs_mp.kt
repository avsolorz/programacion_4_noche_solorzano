fun main(){
    println("Inputs")
    println("Ingresa el nombre del evento:")
    val nombreEvento = readLine()
    println("Evento registrado: $nombreEvento")


    println("Ingresa el presupuesto del evento:")
    val presupuesto = readLine()?.toDoubleOrNull() ?: 0.00
    println("El presupuesto asignado es $presupuesto")


    val gastosAdmin = presupuesto * 0.15
    println("Gastos administrativos (15%): ${gastosAdmin}")
    println("Gastos administrativos (15%): ${presupuesto * 0.15}")
}
