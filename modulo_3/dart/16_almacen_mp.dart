import 'dart:io';

void main() {
  int totalEntradas = 0;
  int entradasDia;

  print("Registro de ventas de entradas semanales");

  for (int dia = 1; dia <= 7; dia++) {
    print("Ingrese las entradas vendidas el día $dia:");

    entradasDia = int.parse(stdin.readLineSync()!);

    totalEntradas += entradasDia;
  }

  double promedio = totalEntradas / 7;

  String rendimiento;

  if (promedio < 20) {
    rendimiento = "Bajo rendimiento";
  }
  else if (promedio <= 60) {
    rendimiento = "Rendimiento normal";
  }
  else {
    rendimiento = "Alto rendimiento";
  }

  print("\n===== RESULTADOS =====");
  print("Total de entradas vendidas: $totalEntradas");
  print("Promedio de entradas por día: $promedio");
  print("Clasificación: $rendimiento");
}
