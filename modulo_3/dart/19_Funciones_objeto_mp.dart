double calcularPresupuestoBasico(double monto)  => monto * 1.10;
double calcularPresupuestoPremium(double monto) => monto * 1.25;

void main() {
  double Function(double) calcular;

  calcular = calcularPresupuestoBasico;
  print(calcular(5000));

  calcular = calcularPresupuestoPremium;
  print(calcular(5000));

  final modalidades = <double Function(double)>[calcularPresupuestoBasico, calcularPresupuestoPremium];
  for (final fn in modalidades) {
    print(fn(10000));
  }
}
