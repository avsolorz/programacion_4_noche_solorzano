import 'dart:io';

void main() {
  int participantes = 1;
  int totalParticipantes = 0;
  int eventosRegistrados = 0;

  while (participantes > 0) {
    print(
      "Ingrese la cantidad de participantes del evento "
      "(0 para finalizar):"
    );

    participantes =
        int.parse(
          stdin.readLineSync()!
        );

    if (participantes > 0) {
      eventosRegistrados++;
      totalParticipantes += participantes;

      if (participantes < 50) {
        print(
          "Evento con baja asistencia"
        );
      } else if (participantes <= 200) {
        print(
          "Evento con asistencia normal"
        );
      } else {
        print(
          "Evento completamente lleno"
        );
      }
    }
  }

  double promedio = 0;

  if (eventosRegistrados > 0) {
    promedio =
        totalParticipantes /
        eventosRegistrados;
  }

  print("\n===== RESULTADOS =====");

  print(
    "Total de participantes registrados: "
    "$totalParticipantes"
  );

  print(
    "Cantidad de eventos registrados: "
    "$eventosRegistrados"
  );

  print(
    "Promedio de participantes por evento: "
    "$promedio"
  );
}
