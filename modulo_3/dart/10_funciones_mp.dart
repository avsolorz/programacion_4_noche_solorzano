void mostrarBienvenida() {
  print('Bienvenido al Gestor de Proyectos de Eventos');
}

void mostrarEvento(String nombreEvento) {
  print('Evento registrado: $nombreEvento');
}

int obtenerMaxParticipantes() {
  return 500;
}

double calcularPresupuesto(double costoBase, double gastosExtra) {
  return costoBase + gastosExtra;
}

double calcularCostoPorParticipante(double presupuesto, int participantes) => presupuesto / participantes;

void mostrarOrganizador(String nombre, [String? cargo]) {
  if (cargo != null) {
    print('Organizador: $nombre — Cargo: $cargo');
  } else {
    print('Organizador: $nombre');
  }
}

void mostrarOrganizadorNamed(String nombre, {String? cargo}) {
  if (cargo != null) {
    print('Organizador: $nombre — Cargo: $cargo');
  } else {
    print('Organizador: $nombre');
  }
}

void main() {
  mostrarBienvenida();
  mostrarEvento('Conferencia Tech 2024');
  int maximo = obtenerMaxParticipantes();
  print(maximo);
  print('El máximo es: ${obtenerMaxParticipantes()}');
  print('El presupuesto total es: ${calcularPresupuesto(8000, 2500)}');
  print('El costo por participante es: ${calcularCostoPorParticipante(10500, 350)}');
  mostrarOrganizador('Laura Gómez');
  mostrarOrganizador('Laura Gómez', 'Directora');
  mostrarOrganizadorNamed('Pedro Sánchez');
  mostrarOrganizadorNamed('Pedro Sánchez', cargo: 'Coordinador');
}
