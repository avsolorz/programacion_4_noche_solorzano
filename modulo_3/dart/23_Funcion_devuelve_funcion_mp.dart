double Function(double) crearCalculadorCosto(double factor) {
  return (double monto) => monto * factor;
}

void main() {
  final conImpuesto    = crearCalculadorCosto(1.12);
  final conComision    = crearCalculadorCosto(1.08);
  final conDescuento   = crearCalculadorCosto(0.90);

  print(conImpuesto(5000.0));
  print(conComision(5000.0));
  print(conDescuento(5000.0));

  bool Function(double) crearValidadorPresupuesto(double min, double max) {
    return (presupuesto) => presupuesto >= min && presupuesto <= max;
  }

  final esEventoBasico   = crearValidadorPresupuesto(0, 3000);
  final esEventoPremium  = crearValidadorPresupuesto(15000, double.infinity);

  print(esEventoBasico(2500.0));
  print(esEventoPremium(18000.0));
  print(esEventoPremium(5000.0));
}
