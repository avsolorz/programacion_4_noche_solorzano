import 'dart:io';

void main() {
  double presupuesto;
  double totalPresupuesto = 0;

  print("Registro de presupuestos por evento");

  for (int evento = 1; evento <= 5; evento++) {
    print("Ingrese el presupuesto del evento $evento:");

    presupuesto = double.parse(stdin.readLineSync()!);

    totalPresupuesto += presupuesto;

    if (presupuesto < 2000) {
      print("Evento pequeño");
    }
    else if (presupuesto <= 8000) {
      print("Evento mediano");
    }
    else {
      print("Evento grande");
    }
  }

  double costoOperativo = totalPresupuesto * 0.10;
  double promedio = totalPresupuesto / 5;

  print("\n===== RESULTADOS =====");
  print("Total de presupuesto registrado: \$$totalPresupuesto");
  print("Costo operativo estimado (10%): \$$costoOperativo");
  print("Promedio de presupuesto por evento: \$$promedio");
}
