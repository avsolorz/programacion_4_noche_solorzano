import 'dart:io';

void main() {
  double horas = 1;
  int tareas = 0;

  int totalTareas = 0;
  int planificadores = 0;

  while (horas > 0) {
    print("Ingrese las horas dedicadas a la planificación (0 para finalizar):");
    horas = double.parse(stdin.readLineSync()!);

    if (horas > 0) {
      print("Ingrese la cantidad de tareas completadas:");
      tareas = int.parse(stdin.readLineSync()!);

      planificadores++;
      totalTareas += tareas;

      double tareasPorHora = tareas / horas;

      if (tareasPorHora < 2) {
        print("Planificación lenta");
      }
      else if (tareasPorHora <= 5) {
        print("Planificación normal");
      }
      else {
        print("Planificación rápida");
      }
    }
  }

  double promedio = 0;

  if (planificadores > 0) {
    promedio = totalTareas / planificadores;
  }

  print("\n===== RESULTADOS =====");
  print("Total de tareas completadas: $totalTareas");
  print("Cantidad de planificadores registrados: $planificadores");
  print("Promedio de tareas por planificador: $promedio");
}
