void main() {
  final nombreEvento = 'Conferencia Tech 2024';
  final capacidad   = 350;

  print('Evento: $nombreEvento');

  print('${nombreEvento.toUpperCase()} tiene ${capacidad + 50} cupos disponibles el próximo mes');

  final fichaEvento = '''
Evento:    $nombreEvento
Capacidad: $capacidad
Premium:   ${capacidad >= 300 ? 'Sí' : 'No'}
  ''';
  print(fichaEvento);

  final rutaAfiche = r'C:\Eventos\Afiches\conferencia.png';
  print(rutaAfiche);

  final encabezado = 'Bienvenidos a ' + nombreEvento + '!';

  print('festival'.toUpperCase());
  print('  Evento Principal  '.trim());
  print('Conferencia'.contains('encia'));
  print('Conferencia'.replaceAll('e', 'E'));
  print('Diseño,Logística,Catering'.split(','));
  print('Conferencia'.substring(0, 5));
  print('Conferencia'.startsWith('Con'));
  print('EVT'.padLeft(7, '0'));
}
