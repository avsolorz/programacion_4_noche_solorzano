List<double> filtrarEventos(List<double> lista, bool Function(double) criterio) {
  return lista.where(criterio).toList();
}

bool esEventoPremium(double presupuesto)    => presupuesto > 10000;
bool esEventoGrande(double presupuesto) => presupuesto > 5000;

void main() {
  final presupuestos = [2500.0, 7000.0, 18000.0, 1200.0, 12000.0, 4500.0, 9500.0, 25000.0];

  print(filtrarEventos(presupuestos, esEventoPremium));
  print(filtrarEventos(presupuestos, esEventoGrande));

  print(filtrarEventos(presupuestos, (p) => p % 2500 == 0));
}
