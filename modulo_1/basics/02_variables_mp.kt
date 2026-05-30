// Declaracion Variables
fun main(){
    //Val Inmutable
    val nombreEvento = "Festival Cultural"
    val capacidad: Int = 1200
    //Var mutable
    var inscritos = 0
    inscritos = inscritos + 1

    println("$nombreEvento tiene capacidad para $capacidad personas")

    //Tipos de datos
    //Numeros Enteros
    val codigoEvento: Byte = 42
    val aforoMaximo: Short = 32_000
    val duracionMinutos: Int = 240
    val totalAsistentesHistorico: Long = 1_500_000_000_000_000

    print(codigoEvento)
    print(aforoMaximo)
    print(duracionMinutos)
    print(totalAsistentesHistorico)

    //Numeros Decimales
    val precioEntrada: Float = 99.99f
    val presupuestoTotal: Double = 125_000.50

    val estaConfirmado: Boolean = true
    //Caracteres
    val tipoEvento: Char = 'C'
    val lugarEvento: String = "Centro de Convenciones"
    val inferido = "evento"

    println("Tipo de inferido: ${inferido::class.simpleName}")
    val capacidadInferida = 500
    println("Tipo de inferido: ${capacidadInferida::class.simpleName}")

    //Utilidades de String
    //Expresiones
    val nombreOrganizador = "Maria"
    val apellidoOrganizador = "Solorzano"

    val nombreMayuscula = nombreOrganizador.uppercase()
    val apellidoMayuscula = apellidoOrganizador.uppercase()

    println("Organizador: ${nombreMayuscula} ${apellidoMayuscula}")
    println("Organizador: ${nombreOrganizador.uppercase()} ${apellidoOrganizador.uppercase()}")

}
