import 'package:flutter/material.dart';

class Competitionbox extends StatefulWidget {
  const Competitionbox(
      {super.key,
      required this.competitionTitle,
      required this.competetionImage});

  final String competitionTitle;
  final String competetionImage;

  @override
  State<Competitionbox> createState() => _CompetitionboxState();
}

class _CompetitionboxState extends State<Competitionbox> {
  @override
  Widget build(BuildContext context) {
    return Container(
        width: 130,
        height: 130,
        decoration: const BoxDecoration(
            borderRadius: BorderRadius.all(Radius.circular(10)),
            color: Colors.black),
        child: ElevatedButton(
          onPressed: null,
          style: ElevatedButton.styleFrom(
              backgroundColor: Colors.black,
              shape: const RoundedRectangleBorder(
                  borderRadius: BorderRadius.all(Radius.circular(10)))),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(widget.competitionTitle,
                  style: const TextStyle(color: Colors.white, fontSize: 12)),
              Image(image: AssetImage(widget.competetionImage))
            ],
          ),
        ));
  }
}
