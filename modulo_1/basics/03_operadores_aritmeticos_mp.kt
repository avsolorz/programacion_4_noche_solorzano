fun main() {
    val presupuesto = 10000.0
    val gastos = 2500.0

    println("Suma")
    println("$presupuesto + $gastos = ${presupuesto + gastos}")

    println("Resta")
    println("$presupuesto - $gastos = ${presupuesto - gastos}")

    println("Multiplicacion")
    val participantes = 200
    val costoEntrada = 50
    println("$participantes * $costoEntrada = ${participantes * costoEntrada}")

    println("Division")
    val totalIngresos = 10000
    val numPatrocinadores = 4
    println("$totalIngresos / $numPatrocinadores = ${totalIngresos / numPatrocinadores}")

    println("Modulo")
    val tareasRestantes = 17
    val equipos = 4
    println("$tareasRestantes % $equipos = ${tareasRestantes % equipos}")

    println("Operadores de Asignacion Compuesta")
    var presupuestoActual = 10000.0

    presupuestoActual += 5000.0
    println("presupuesto += 5000 -> $presupuestoActual")

    presupuestoActual -= 3000.0
    println("presupuesto -= 3000 -> $presupuestoActual")

    presupuestoActual *= 2
    println("presupuesto *=2 ${presupuestoActual}")

    presupuestoActual /= 4
    println("presupuesto /=4 ${presupuestoActual}")

    presupuestoActual %= 4
    println("presupuesto %=4 ${presupuestoActual}")

    //Incremento decremento

}
