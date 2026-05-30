void main() {
  int tareasRegistradas = 0;
  int presupuestoDisponible = 5000;

  while (presupuestoDisponible > 0) {
    final costo = presupuestoDisponible > 1000 ? 1000 : presupuestoDisponible;
    tareasRegistradas++;
    presupuestoDisponible -= costo;
    print('Tarea $tareasRegistradas: \$$costo asignados (restante: \$$presupuestoDisponible)');
  }

  int intentos = 0;
  bool organizadorConfirmado = false;

  do {
    intentos++;
    print('Contactando organizador, intento #$intentos...');
    if (intentos == 3) organizadorConfirmado = true;
  } while (!organizadorConfirmado && intentos < 5);

  print(organizadorConfirmado
      ? 'Organizador confirmado tras $intentos intentos'
      : 'No se pudo contactar al organizador');
}
