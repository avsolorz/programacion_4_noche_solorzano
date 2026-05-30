fun main() {
  println("When con bloques de codigo")
  println("Nombre del Evento:")
  val evento = readLine()?.trim() ?: ""
  println("Prioridad del evento CRITICA/URGENTE/NORMAL/BAJA:")
  val prioridad = readLine()?.trim()?.uppercase() ?: ""

  when (prioridad){
      "CRITICA"->{
        println("ALERTA CRITICA EVENTO. $evento")
        println("Accion Inmediata requerida")
        println("Registrar hora de activacion del protocolo de emergencia")
      }
        "URGENTE"->{
            println("URGENTE EVENTO. $evento")
            println("PRIORIZAR RECURSOS Y EQUIPO")
            println("Registrar hora de activacion de contingencia")
        }
        "NORMAL"->println("NORMAL EVENTO. $evento, registrar y monitorear avance")
        "BAJA"->println("BAJA PRIORIDAD EVENTO. $evento, agregar a lista de pendientes")
        else-> println("Prioridad no reconocida")
  }

  println("Duracion del evento (dias):")
  val dias = readLine()?.toIntOrNull() ?: 0
  val categoria = when(dias){
      in 1..1   -> "Evento de un dia"
      in 2..3   -> "Evento de fin de semana"
      in 4..7   -> "Evento semanal"
      in 8..30  -> "Evento mensual"
      else      -> "Evento de larga duracion"
  }
  println("$dias dias -> $categoria")


}
