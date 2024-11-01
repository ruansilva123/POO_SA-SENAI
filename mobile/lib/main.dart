import 'package:flutter/material.dart';
import 'widgets/appbarwidget.dart';
import 'widgets/competitionBox.dart';

void main() {
  runApp(const MaterialApp(home: MyApp()));
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const Scaffold(
        appBar: AppBarArrow(title: "Competitions"),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text("Choose a competition", style: TextStyle(fontSize: 30)),
              SizedBox(height: 50),
              SizedBox(
                width: 300,
                child: Row(
                  children: [
                    Competitionbox(
                        competitionTitle: "Mundial",
                        competetionImage: "assets/img/mundial.png"),
                    SizedBox(width: 30),
                    Competitionbox(
                        competitionTitle: "Libertadores",
                        competetionImage: "assets/img/Libertadores_logo.png"),
                  ],
                ),
              ),
              SizedBox(height: 50),
              SizedBox(
                width: 300,
                child: Row(
                  children: [
                    Competitionbox(
                        competitionTitle: "Brasileirão",
                        competetionImage: "assets/img/brasileirao_logo.png"),
                    SizedBox(width: 30),
                    Competitionbox(
                        competitionTitle: "Bundesliga",
                        competetionImage: "assets/img/bundesliga_logo.png"),
                  ],
                ),
              ),
              SizedBox(height: 50),
              SizedBox(
                width: 300,
                child: Row(
                  children: [
                    Competitionbox(
                        competitionTitle: "La Liga",
                        competetionImage: "assets/img/la_liga.png"),
                    SizedBox(width: 30),
                    Competitionbox(
                        competitionTitle: "Premiere League",
                        competetionImage: "assets/img/premiere_league.png"),
                  ],
                ),
              )
            ],
          ),
        ));
  }
}
