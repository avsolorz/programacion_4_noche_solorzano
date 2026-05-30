fun main() {
    println("Funcion Lamba")
    val calcularPresupuesto:(Double, Double)->Double={ base: Double, porcentaje: Double -> base + (base * porcentaje / 100) }
    println(calcularPresupuesto(5000.0, 15.0) )
    //Inferido
    val calcularDescuento:(Double, Double)->Double={ monto, descuento -> monto - (monto * descuento / 100) }
    println(calcularDescuento(1000.0, 20.0) )
    //parametro implicito it
    val aplicarIva:(Double)->Double={ it * 1.13 }
    println(aplicarIva(2500.0) )

}
