fun main() {
    println("Operadores Lógicos")

    val estaConfirmado = true
    val tienePresupuesto = false
    val lugarDisponible = true
    val organizadorAsignado = false

    println("Operador And &&")
    println("$estaConfirmado && $tienePresupuesto = ${estaConfirmado && tienePresupuesto}")
    println("$estaConfirmado && $lugarDisponible = ${estaConfirmado && lugarDisponible}")

    println("Operador Or ||")
    println("$estaConfirmado || $tienePresupuesto = ${estaConfirmado || tienePresupuesto}")
    println("$estaConfirmado || $lugarDisponible = ${estaConfirmado || lugarDisponible}")
    println("$organizadorAsignado || $tienePresupuesto = ${organizadorAsignado || tienePresupuesto}")
    println("$organizadorAsignado || $tienePresupuesto || $lugarDisponible = ${organizadorAsignado || tienePresupuesto || lugarDisponible}")

    println("Operador Not !")
    println("!$estaConfirmado = ${!estaConfirmado}")
    println("!$organizadorAsignado = ${!organizadorAsignado}")

    val texto = readLine()
    println(texto)
}
