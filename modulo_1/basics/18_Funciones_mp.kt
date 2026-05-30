fun main () {
  registrarEvento()
  registrarConNombre("Conferencia Tech")
  val presupuesto = 15000.0
  val gastos = 4500.0
  println("Saldo de $presupuesto - $gastos = ${calcularSaldo(presupuesto, gastos)}")
  println("Diferencia de $presupuesto - $gastos = ${calcularDiferencia(presupuesto, gastos)}")
  calcularMetricas()
  println("Ingresos totales $presupuesto * 2 participantes = ${calcularIngresos(presupuesto, 2)}")
}

fun registrarEvento(){
    println("Nuevo evento registrado en el sistema")
}

fun registrarConNombre(nombre: String){
    println("Evento registrado: $nombre")
}

fun calcularSaldo(presupuesto: Double, gastos: Double): Double{
    return presupuesto - gastos
}

// funcion simplificada
fun calcularDiferencia(presupuesto: Double, gastos: Double) = presupuesto - gastos

//funcion dentro de funcion
fun calcularMetricas(){
    fun porcentajeOcupacion(inscritos: Int, capacidad: Int) = (inscritos * 100) / capacidad
    println(porcentajeOcupacion(80, 100))
}

//funciones como variables
val calcularIngresos = { precio: Double, cantidad: Int -> precio * cantidad }
