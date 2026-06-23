
import 'package:flutter/material.dart';

class AvatarBadge extends StatelessWidget {
  final String  iniciales;
  final Color   color;
  final int     badge;

  const AvatarBadge({
    super.key,
    required this.iniciales,
    required this.color,
    this.badge = 0,
  });

  @override
  Widget build(BuildContext context) {
    return Stack(
      clipBehavior: Clip.none,
      children: [
        CircleAvatar(
          backgroundColor: color,
          radius: 28,
          child: Text(iniciales,
              style: const TextStyle(color: Colors.white, fontWeight: FontWeight.bold)),
        ),
        if (badge > 0)
          Positioned(
            top:   -4,
            right: -4,
            child: Container(
              padding:    const EdgeInsets.all(4),
              decoration: const BoxDecoration(
                color: Colors.red, shape: BoxShape.circle),
              child: Text('$badge',
                  style: const TextStyle(color: Colors.white, fontSize: 10)),
            ),
          ),
      ],
    );
  }
}
