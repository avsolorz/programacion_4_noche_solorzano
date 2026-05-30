import 'dart:io';

void main() {
  int patrocinadores, total = 0, gestores = 0;

  stdout.write("Patrocinadores conseguidos (0 para salir): ");
  patrocinadores = int.parse(stdin.readLineSync()!);

  while (patrocinadores > 0) {

    if (patrocinadores < 3) {
      print("Gestión lenta");
    } else if (patrocinadores <= 8) {
      print("Gestión eficiente");
    } else {
      print("Gestión sobresaliente");
    }

    total += patrocinadores;
    gestores++;

    stdout.write("Patrocinadores conseguidos (0 para salir): ");
    patrocinadores = int.parse(stdin.readLineSync()!);
  }

  print("\nTotal de patrocinadores: $total");
  print("Gestores registrados: $gestores");

  if (gestores > 0) {
    print("Promedio: ${total / gestores}");
  }
}
