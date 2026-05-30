void main() {
  final calcularAforo = (int capacidad) => capacidad * capacidad;
  print(calcularAforo(20));

  final calcularCostoFinal = (double presupuesto, double porcentajeExtra) {
    final extra = presupuesto * (porcentajeExtra / 100);
    return presupuesto + extra;
  };
  print(calcularCostoFinal(10000.0, 15.0));

  final presupuestos = [3000.0, 1200.0, 8500.0, 500.0, 6700.0, 2100.0, 4300.0, 9800.0];
  presupuestos.sort((a, b) => b.compareTo(a));
  print(presupuestos);
}
