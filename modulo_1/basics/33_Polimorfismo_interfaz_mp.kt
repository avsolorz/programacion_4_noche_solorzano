// La interfaz define el contrato — QUÉ puede hacer
// Las implementaciones definen el CÓMO
interface Notificable {
    fun enviar(mensaje: String): Boolean
    val nombre: String
}

class NotificacionEmail(val destinatario: String) : Notificable {
    override val nombre = "Correo electrónico"
    override fun enviar(mensaje: String): Boolean {
        println("📧 Enviando a $destinatario: $mensaje")
        return true
    }
}

class NotificacionSMS(val telefono: String) : Notificable {
    override val nombre = "SMS"
    override fun enviar(mensaje: String): Boolean {
        println("📱 SMS a $telefono: $mensaje")
        return true
    }
}

class NotificacionWhatsApp(val telefono: String) : Notificable {
    override val nombre = "WhatsApp"
    override fun enviar(mensaje: String): Boolean {
        println("💬 WhatsApp a $telefono: $mensaje")
        return true
    }
}

class NotificacionPush(val deviceId: String) : Notificable {
    override val nombre = "Push Notification"
    override fun enviar(mensaje: String): Boolean {
        println("🔔 Push a dispositivo $deviceId: $mensaje")
        return true
    }
}

// Esta función no sabe ni le importa qué tipo de notificación es
// Solo sabe que recibe algo que implementa Notificable — POLIMORFISMO
fun notificar(mensaje: String, canal: Notificable) {
    println("Enviando notificación via ${canal.nombre}...")
    val exito = canal.enviar(mensaje)
    println(if (exito) "✅ Notificación enviada" else "❌ Error al notificar")
}

fun main() {
    val canales: List<Notificable> = listOf(
        NotificacionEmail("organizador@eventos.com"),
        NotificacionSMS("+50312345678"),
        NotificacionWhatsApp("+50398765432"),
        NotificacionPush("device-abc-123")
    )

    // Misma función — comportamiento distinto según el tipo
    canales.forEach { notificar("Evento confirmado para mañana a las 9am", it) }
}
