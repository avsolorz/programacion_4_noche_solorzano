import 'dart:io';

Future<String> obtenerDetallesEvento() async {
  await Future.delayed(Duration(milliseconds: 200));
  return 'Conferencia Tech 2024 | Quito | 350 participantes';
}

void main() async {
  print('Consultando detalles del evento...');
  final detalles = await obtenerDetallesEvento();
  print('Evento: $detalles');
  print('Consulta completada');
}
