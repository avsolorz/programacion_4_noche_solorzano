import 'dart:io';

void main() {
  int actividades = 1;
  int totalActividades = 0;
  int coordinadores = 0;

  while (actividades > 0) {
    print("Ingrese la cantidad de actividades planificadas (0 para finalizar):");

    actividades = int.parse(stdin.readLineSync()!);

    if (actividades > 0) {
      coordinadores++;
      totalActividades += actividades;

      if (actividades < 3) {
        print("Planificación baja");
      }
      else if (actividades <= 7) {
        print("Planificación normal");
      }
      else {
        print("Planificación alta");
      }
    }
  }

  double promedio = 0;

  if (coordinadores > 0) {
    promedio = totalActividades / coordinadores;
  }

  print("\n===== RESULTADOS =====");
  print("Total de actividades planificadas: $totalActividades");
  print("Cantidad de coordinadores registrados: $coordinadores");
  print("Promedio de actividades por coordinador: $promedio");
}
