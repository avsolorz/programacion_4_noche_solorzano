
import 'package:flutter/material.dart';

class AvatarBadge extends StatelessWidget {
  final String nombre;
  final int    alertas;
  final bool   activo;

  const AvatarBadge({
    super.key,
    required this.nombre,
    required this.activo,
    this.alertas = 0,
  });

  @override
  Widget build(BuildContext context) {
    return Stack(
      clipBehavior: Clip.none,
      children: [
        CircleAvatar(
          backgroundColor: activo ? Colors.indigo : Colors.grey,
          radius: 28,
          child: Text(
            nombre.substring(0, 2).toUpperCase(),
            style: const TextStyle(color: Colors.white, fontWeight: FontWeight.bold),
          ),
        ),
        if (alertas > 0)
          Positioned(
            top:   -4,
            right: -4,
            child: Container(
              padding:    const EdgeInsets.all(4),
              decoration: const BoxDecoration(
                color: Colors.red, shape: BoxShape.circle),
              child: Text('$alertas',
                  style: const TextStyle(color: Colors.white, fontSize: 10)),
            ),
          ),
        Positioned(
          bottom: 0,
          right:  0,
          child: Container(
            width:  12,
            height: 12,
            decoration: BoxDecoration(
              color:  activo ? Colors.green : Colors.grey,
              shape:  BoxShape.circle,
              border: Border.all(color: Colors.white, width: 2),
            ),
          ),
        ),
      ],
    );
  }
}
