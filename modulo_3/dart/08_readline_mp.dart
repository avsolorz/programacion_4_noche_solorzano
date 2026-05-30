import 'dart:io';

void main() {
  print('Ingrese el nombre del evento:');
  String? nombreEvento = stdin.readLineSync();
  print('Evento registrado: $nombreEvento');


for (int i = 0; i < 3; i++) {
    print('Ingrese la cantidad de participantes del evento ${i + 1}:');
    int participantes = int.parse(stdin.readLineSync()!);
    print('Participantes: $participantes');
  }

  print('Ingrese la cantidad total de tareas del evento:');
  int tareas = int.parse(stdin.readLineSync()!);
  print('Tareas: $tareas');




  print('Ingrese el presupuesto del evento:');
  double presupuesto = double.parse(stdin.readLineSync()!);
  print('Presupuesto: $presupuesto');
}
