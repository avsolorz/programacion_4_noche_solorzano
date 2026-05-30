interface Exportable { fun exportar() = println("Exportando datos del evento") }
interface Imprimible { fun exportar() = println("Imprimiendo reporte del evento") }

class InformeEvento : Exportable, Imprimible {
    // Obligatorio cuando ambas tienen implementación del mismo método
    override fun exportar() {
        super<Exportable>.exportar()
        super<Imprimible>.exportar()
        println("Y generando informe completo del evento")
    }
}
