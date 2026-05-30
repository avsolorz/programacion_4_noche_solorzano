void main() {
  double presupuesto = 8500.0;

  if (presupuesto > 10000) {
    print('Presupuesto alto');
  } else if (presupuesto > 5000) {
    print('Presupuesto medio');
  } else {
    print('Presupuesto bajo');
  }

  String nivelPresupuesto = presupuesto > 10000 ? 'Premium' : 'Estándar';
  print(nivelPresupuesto);

  String? lugarEvento;
  String display = lugarEvento != null ? lugarEvento.toUpperCase() : 'Sin lugar';

  String display2 = lugarEvento?.toUpperCase() ?? 'Sin lugar';
  print(display2);

  String? organizador;

  if (organizador != null) {
    print(organizador.length);
  }

  print(organizador?.length);

  int longitud = organizador?.length ?? 0;
  print(longitud);
}
