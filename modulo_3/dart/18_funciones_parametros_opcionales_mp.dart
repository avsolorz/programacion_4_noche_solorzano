String construirUrlEvento(String organizador, String nombreEvento, [int? capacidad]) {
  if (capacidad != null) {
    return 'https://eventos.app/$organizador/$nombreEvento?cap=$capacidad';
  }
  return 'https://eventos.app/$organizador/$nombreEvento';
}

String construirUrlEventoV2(String organizador, String nombreEvento, [int capacidad = 100]) {
  return 'https://eventos.app/$organizador/$nombreEvento?cap=$capacidad';
}

void configurarEvento({
  required String nombreEvento,
  required String lugar,
  bool esPresencial = true,
  int duracionHoras = 4,
}) {
  final modalidad = esPresencial ? 'Presencial' : 'Virtual';

  print(
      'Evento: $nombreEvento | Lugar: $lugar | Modalidad: $modalidad | Duración: ${duracionHoras}h');
}

void main() {
  print(construirUrlEvento('maria_lopez', 'conferencia-tech'));
  print(construirUrlEvento('maria_lopez', 'conferencia-tech', 300));
  print(construirUrlEventoV2('carlos_ruiz', 'gala-premios'));

  configurarEvento(
    nombreEvento: 'Cumbre Empresarial 2024',
    lugar: 'Centro de Convenciones',
    esPresencial: false,
    duracionHoras: 8,
  );

  configurarEvento(
    nombreEvento: 'Workshop de Innovación',
    lugar: 'Auditorio Principal',
  );
}
