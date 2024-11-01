import 'package:flutter/material.dart';

class AppBarArrow extends StatefulWidget implements PreferredSizeWidget {
  const AppBarArrow({super.key, required this.title});

  final String title;

  @override
  State<AppBarArrow> createState() => _AppBarArrowState();

  @override
  Size get preferredSize => const Size.fromHeight(100.0);
}

class _AppBarArrowState extends State<AppBarArrow> {
  @override
  Widget build(BuildContext context) {
    return AppBar(
      backgroundColor: Colors.black,
      flexibleSpace: Center(
        child: Text(
          widget.title,
          style: const TextStyle(
            color: Colors.white,
            fontSize: 20
          ), 
        ),
      ),
    );
  }
}
