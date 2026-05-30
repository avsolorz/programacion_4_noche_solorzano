void main() {
  final presupuestos = [5000.0, 12000.0, 3500.0, 18000.0];

  final presupuestosConImpuesto = presupuestos.map((p) => p * 1.12);
  print(presupuestosConImpuesto.toList());

  final nombresEvento = ['conferencia-anual', 'gala-premios', 'workshop-tech'];
  final urlsEvento = nombresEvento.map((e) => 'https://eventos.app/$e');
  print(urlsEvento.toList());

  final presupuestosRegistrados = [4500.0, 11000.0, 22000.0, 3200.0, 15500.0, 800.0];

  final eventosPremium = presupuestosRegistrados.where((p) => p > 10000);
  print(eventosPremium.toList());

  final eventosEstandar = presupuestosRegistrados.where((p) => p >= 3000.0 && p <= 10000.0);
  print(eventosEstandar.toList());

  final ingresos = [8000.0, 15000.0, 4500.0, 22000.0, 3500.0];

  final totalIngresos = ingresos.reduce((acum, ingreso) => acum + ingreso);
  print('Total ingresos: \$${totalIngresos.toStringAsFixed(2)}');

  final totalFold = ingresos.fold(0.0, (acum, ingreso) => acum + ingreso);
  print('Total (fold): \$${totalFold.toStringAsFixed(2)}');

  final maximo = ingresos.reduce((a, b) => a > b ? a : b);
  print('Mayor ingreso: \$$maximo');
}
