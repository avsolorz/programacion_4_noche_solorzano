fun main () {
    println("Map")
    println("Inmutables")
    val sedesEventos = mapOf(
        "Conferencia Tech" to "Centro de Convenciones",
        "Festival Cultural" to "Parque Central",
        "Hackathon 2025" to "Universidad Nacional",
        "Gala de Premiacion" to "Hotel Grand Plaza"
    )

    println(sedesEventos["Conferencia Tech"])
    println(sedesEventos["Congreso"])
    println(sedesEventos.getOrDefault("Conferencia Tech", "Sede por definir"))
    println(sedesEventos.getOrDefault("Congreso", "Sede por definir"))
    println(sedesEventos.keys)
    println(sedesEventos.values)
    println(sedesEventos.entries)
    println(sedesEventos)

    for ((evento, sede) in sedesEventos){
        println("evento: $evento - sede: $sede")
    }

     for (entrada in sedesEventos){
         println("entrada: $entrada")
     }


    println("Mutables")
    val presupuestosPorArea = mutableMapOf(
        "Logistica" to 5000.0,
        "Marketing" to 3000.0,
        "Catering" to 8000.0,
        "Tecnologia" to 4000.0
    )

    presupuestosPorArea["Seguridad"] = 2500.0
    println(presupuestosPorArea)
    presupuestosPorArea["Logistica"] = 6000.0
    println(presupuestosPorArea)
    presupuestosPorArea.remove("Catering")
    println(presupuestosPorArea)
    presupuestosPorArea.getOrPut("Entretenimiento"){ 3500.0 }
    println(presupuestosPorArea)
    presupuestosPorArea.getOrPut("Marketing"){ 5000.0 }
    println(presupuestosPorArea)



}
