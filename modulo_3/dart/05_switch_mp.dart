void main() {
  String estadoEvento = 'cancelado';

  switch (estadoEvento) {
    case 'planificado':
      print('En planificación');
    case 'confirmado':
      print('Confirmado');
    case 'en_curso':
      print('En curso');
    case 'cancelado':
      print('Cancelado');
    case 'finalizado':
      print('Finalizado');
    case 'pospuesto':
      print('Pospuesto');
    default:
      print('Estado desconocido');
  }

  estadoEvento = 'confirmado';

  String descripcion = switch (estadoEvento) {
    'planificado' => 'Planificado — en fase de organización',
    'confirmado'  => 'Confirmado — fecha y lugar definidos',
    'en_curso'    => 'En curso — evento actualmente activo',
    'cancelado'   => 'Cancelado — evento no se realizará',
    'finalizado'  => 'Finalizado — evento completado con éxito',
    'pospuesto'   => 'Pospuesto — nueva fecha por definir',
    _             => 'Estado de evento desconocido',
  };

  print(descripcion);

  int participantes = 320;

  String categoria = switch (participantes) {
    int p when p <= 50               => 'Micro evento',
    int p when p <= 150              => 'Evento pequeño',
    int p when p <= 400              => 'Evento mediano',
    int p when p <= 1000             => 'Evento grande',
    _                                => 'Evento masivo',
  };

  print(categoria);

  double porcentajeVentas = 78.5;

  String alerta = switch (porcentajeVentas) {
    double p when p >= 95.0 => '🚨 SOLD OUT — lista de espera activa',
    double p when p >= 80.0 => '🔴 CASI LLENO — quedan pocas entradas',
    double p when p >= 50.0 => '🟡 BUENAS VENTAS — sigue promocionando',
    double p when p >= 20.0 => '🟢 EN PROGRESO — ventas normales',
    _                       => '🔵 INICIO — ventas recién comenzaron',
  };

  print(alerta);

  Object respuestaApi = {'id': 'EVT-001', 'nombre': 'Gala de Premiación', 'presupuesto': 25000.0};

  String resultado = switch (respuestaApi) {
    Map<String, dynamic> m when m.containsKey('error') =>
        'Error: ${m['error']}',
    Map<String, dynamic> m =>
        'Evento: ${m['nombre']} — Presupuesto: \$${m['presupuesto']}',
    List<dynamic> lista =>
        '${lista.length} eventos en la lista',
    String texto =>
        'Texto recibido: $texto',
    _ =>
        'Respuesta desconocida',
  };

  print(resultado);
}
