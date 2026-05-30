int calcularCombinaciones(int n) {
  if (n <= 1) return 1;
  return n * calcularCombinaciones(n - 1);
}

int presupuestoEtapa(int n) {
  if (n <= 1) return n;
  return presupuestoEtapa(n - 1) + presupuestoEtapa(n - 2);
}

int contarTareas(Map<String, dynamic> fase) {
  int total = 0;
  for (final entrada in fase.entries) {
    if (entrada.value is Map) {
      total += contarTareas(entrada.value as Map<String, dynamic>);
    } else {
      total++;
    }
  }
  return total;
}

void main() {
  print(calcularCombinaciones(6));
  print(presupuestoEtapa(10));

  final planEvento = {
    'preproduccion': {
      'diseno': {'afiche.png': true, 'programa.pdf': true},
      'logistica':      {'lista_proveedores.xlsx': true},
      'presupuesto':    {'cotizacion.xlsx': true, 'aprobacion.pdf': true},
    },
    'ejecucion': {'cronograma.pdf': true},
    'contrato_lugar.pdf': true,
    'lista_invitados.xlsx':    true,
  };

  print('Total de tareas del evento: ${contarTareas(planEvento)}');
}
