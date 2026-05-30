fun main(){
    println("Control de flujo")
    println("if Dos Caminos")
    println("El evento tiene patrocinador? s/n")
    val tienePatrocinador = readLine()?.trim()?.lowercase() == "s"
    println("Presupuesto base del evento? $")
    val presupuestoBase = readLine()?.toDoubleOrNull() ?: 0.0
    if(tienePatrocinador){
        val aporte = presupuestoBase * 0.40
        println("Patrocinador cubre $aporte  Organizacion cubre ${presupuestoBase - aporte}")
    } else {
        println("Organizacion cubre el total: $presupuestoBase")
    }
}
