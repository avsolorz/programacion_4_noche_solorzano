class Evento {
  final String id;
  final String nombre;
  String       lugar;
  bool         _activo = false;

  Evento({
    required this.id,
    required this.nombre,
    required this.lugar,
  });

  bool   get activo => _activo;
  String get estado    => _activo ? 'en curso' : 'inactivo';

  set estadoActivo(bool valor) {
    _activo = valor;
    print('$nombre: ${valor ? "iniciado" : "finalizado"}');
  }

  void iniciar() {
    _activo = true;
    print('$nombre iniciado en $lugar');
  }

  void finalizar() {
    _activo = false;
    print('$nombre finalizado');
  }

  String resumen() => 'ID: $id | Nombre: $nombre | Lugar: $lugar | Estado: $estado';

  @override
  String toString() => 'Evento($nombre, $lugar, $estado)';
}

void main() {
  final conferencia = Evento(
    id:     'EVT-001',
    nombre: 'Conferencia Tech 2024',
    lugar:  'Centro de Convenciones Quito',
  );

  conferencia.iniciar();
  print(conferencia.estado);
  print(conferencia.resumen());
  print(conferencia);

  conferencia.estadoActivo = false;
  print(conferencia.activo);
}
