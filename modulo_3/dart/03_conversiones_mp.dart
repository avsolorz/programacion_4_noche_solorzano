void main() {
  int    participantes = 250;
  double capacidadTotal = participantes.toDouble();
  String textoParticipantes = participantes.toString();

  int    cuposReservados = int.parse('180');
  double presupuesto = double.parse('15000.50');

  int?    invitadosVip = int.tryParse('abc');
  double? costoExtra  = double.tryParse('350');

  Object valor = 'Conferencia Anual';
  if (valor is String) {
    print(valor.length);
  }

  Object obj = 'Nombre del Evento';
  String str = obj as String;

  String? lugarEvento = null;
  int longitud = lugarEvento?.length ?? 0;
  print(longitud);

  print(double.infinity);
  print(double.nan);
  print(double.maxFinite);
}
