void main() {
  for (int i = 0; i < 5; i++) {
    print('Tarea $i registrada');
  }

  for (int i = 0; i <= 100; i += 25) {
    print('Avance del evento: $i%');
  }

  for (int i = 5; i >= 1; i--) {
    print('Días para el evento: $i');
  }

  final tareasEvento = ['Diseño', 'Logística', 'Catering', 'Sonido', 'Decoración'];

  for (final tarea in tareasEvento) {
    print(tarea);
  }

  tareasEvento.forEach((t) => print(t.toLowerCase()));

  final responsables = {'Diseño': 'Ana', 'Logística': 'Carlos', 'Catering': 'Luisa', 'Sonido': 'Pedro'};
  for (final entrada in responsables.entries) {
    print('${entrada.key} → responsable: ${entrada.value}');
  }
}
