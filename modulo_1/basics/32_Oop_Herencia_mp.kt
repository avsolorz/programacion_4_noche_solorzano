// Sin open — no se puede heredar (protección por defecto)
// class EventoBase(val nombre: String)
// class EventoPresencial : EventoBase("Tech")  // ERROR — EventoBase es final

// Con open — la jerarquía está diseñada para ello
open class EventoBase(val nombre: String, val tipo: String) {
    // open — la subclase PUEDE sobreescribir
    open fun mostrarInfo() = println("$nombre es un evento de tipo: $tipo")
    open fun descripcion() = "Evento: $nombre"

    // Sin open — la subclase NO puede sobreescribir
    fun registrar() = println("$nombre registrado en el sistema")
}

// HERENCIA: EventoPresencial reutiliza todo de EventoBase y especializa mostrarInfo
class EventoPresencial(nombre: String, val sede: String) : EventoBase(nombre, "Presencial") {
    override fun mostrarInfo() {
        super.mostrarInfo()                     // reutiliza la implementación del padre
        println("(Sede: $sede)")                // añade comportamiento propio
    }
    override fun descripcion() = "${super.descripcion()}, evento presencial"
}

class EventoVirtual(nombre: String, val plataforma: String) : EventoBase(nombre, "Virtual") {
    override fun descripcion() =
        "${super.descripcion()}, evento virtual en $plataforma"
}

fun main() {
    val presencial = EventoPresencial("Conferencia Tech", "Centro de Convenciones")
    presencial.mostrarInfo()
    // Conferencia Tech es un evento de tipo: Presencial
    // (Sede: Centro de Convenciones)

    val virtual = EventoVirtual("Webinar IA", "Zoom")
    println(virtual.descripcion())

    // Herencia — EventoPresencial y EventoVirtual tienen todo lo de EventoBase más lo propio
    presencial.registrar()  // heredado de EventoBase
}
