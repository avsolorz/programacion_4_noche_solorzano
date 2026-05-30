import 'dart:io';

void main() {
  int tareas = 1;
  int totalTareas = 0;
  int organizadores = 0;

  while (tareas > 0) {
    print("Ingrese las tareas completadas por el organizador (0 para finalizar):");

    tareas = int.parse(stdin.readLineSync()!);

    if (tareas > 0) {
      organizadores++;
      totalTareas += tareas;


      if (tareas < 5) {
        print("Rendimiento insuficiente");
      }
      else if (tareas <= 15) {
        print("Rendimiento adecuado");
      }
      else {
        print("Rendimiento sobresaliente");
      }
    }
  }

  double promedio = 0;

  if (organizadores > 0) {
    promedio = totalTareas / organizadores;
  }

  print("\n===== RESULTADOS =====");
  print("Total de tareas completadas: $totalTareas");
  print("Cantidad de organizadores registrados: $organizadores");
  print("Promedio de tareas por organizador: $promedio");
}
