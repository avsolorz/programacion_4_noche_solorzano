void main() {
  var nombreEvento = 'Festival de Verano';
  var capacidad = 500;
  var presupuesto = 12500.00;
  var activo = true;

  String organizador = 'María López';
  int participantes = 200;
  double porcentajeAvance = 75.5;
  bool confirmado = false;

  final ciudad = 'Quito';

  const impuesto = 0.12;
  const maxParticipantes = 1000;

  final fechaCreacion = DateTime.now();

  print('$nombreEvento organizado por $organizador tiene $capacidad cupos en $ciudad');

  var tareasCompletadas = 0;
  tareasCompletadas = 1;

  print('Tareas completadas: $tareasCompletadas');

  final tareas = ['Diseño', 'Logística', 'Catering'];
  tareas.add('Sonido');

  print('Lista de tareas: $tareas');

  const estados = ['Planificado', 'En curso'];

  String nombreOrganizador = 'Carlos Ruiz';

  String? patrocinador = null;
  patrocinador = 'Empresa XYZ';

  String? lugarEvento;

  print(lugarEvento?.length);

  String resultado = lugarEvento ?? 'Sin lugar asignado';
  print(resultado);

  lugarEvento = 'Centro de Convenciones';

  String lugarSeguro = lugarEvento!;
  print(lugarSeguro);

  if (patrocinador != null) {
    print(patrocinador.length);
  }

  late String codigoEvento;
  codigoEvento = 'EVT-2024-001';

  print(codigoEvento);

  print(presupuesto);
  print(activo);
  print(participantes);
  print(porcentajeAvance);
  print(confirmado);
  print(impuesto);
  print(maxParticipantes);
  print(fechaCreacion);
  print(nombreOrganizador);
}
