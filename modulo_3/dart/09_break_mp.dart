void main() {
  final tareasEvento = [120, 350, 80, -1, 200, 500, -1, 60];

  print('=== Procesando con continue ===');
  for (final costo in tareasEvento) {
    if (costo < 0) {
      print('Tarea con costo inválido ignorada');
      continue;
    }
    print('Procesando tarea con costo de \$$costo');
  }

  print('\n=== Procesando con break ===');
  for (final costo in tareasEvento) {
    if (costo < 0) {
      print('Error crítico — deteniendo registro de tareas');
      break;
    }
    print('Procesando tarea con costo de \$$costo');
  }
}
