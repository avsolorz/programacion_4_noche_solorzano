import 'dart:io';

void main() {
  int eventos = 1;
  int participantes = 0;
  int incidencias = 0;

  int totalParticipantes = 0;
  int totalIncidencias = 0;
  int totalEventos = 0;
  int coordinadores = 0;

  while (eventos > 0) {
    print("Ingrese la cantidad de eventos coordinados (0 para finalizar):");
    eventos = int.parse(stdin.readLineSync()!);

    if (eventos > 0) {
      print("Ingrese la cantidad de participantes gestionados:");
      participantes = int.parse(stdin.readLineSync()!);

      print("Ingrese los minutos totales de incidencias:");
      incidencias = int.parse(stdin.readLineSync()!);

      coordinadores++;

      totalParticipantes += participantes;
      totalIncidencias += incidencias;
      totalEventos += eventos;

      double participantesPorEvento = participantes / eventos;
      double incidenciaPorEvento = incidencias / eventos;

      print("Participantes por evento: $participantesPorEvento");
      print("Incidencias por evento: $incidenciaPorEvento");

      if (participantesPorEvento < 30) {
        print("Baja eficiencia");
      }
      else if (participantesPorEvento <= 100) {
        print("Eficiencia normal");
      }
      else {
        print("Alta eficiencia");
      }
    }
  }

  double promedioParticipantes = 0;
  double promedioIncidenciaGeneral = 0;

  if (coordinadores > 0) {
    promedioParticipantes = totalParticipantes / coordinadores;
  }

  if (totalEventos > 0) {
    promedioIncidenciaGeneral = totalIncidencias / totalEventos;
  }

  print("\n===== RESULTADOS =====");
  print("Total de participantes gestionados: $totalParticipantes");
  print("Total de minutos de incidencias acumuladas: $totalIncidencias");
  print("Cantidad de coordinadores registrados: $coordinadores");
  print("Promedio de participantes por coordinador: $promedioParticipantes");
  print("Promedio general de incidencias por evento: $promedioIncidenciaGeneral");
}
