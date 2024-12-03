CREATE TABLE teams(
    id_team SERIAL PRIMARY KEY,
    name_team TEXT NOT NULL
);

CREATE TABLE players(
    id_player = SERIAL PRIMARY KEY,
    name_player = TEXT NOT NULL,
    team_id INTEGER NOT NULL,
    FOREIGN KEY (team_id) REFERENCES teams(id_team)
);

CREATE TABLE competitions(
    id_competition SERIAL PRIMARY KEY,
    name_competition TEXT NOT NUll
);

CREATE TABLE matches(
    id_match SERIAL PRIMARY KEY,
    date_match DATETIME NOT NULL,
    home_team_goals INTEGER NOT NULL,
    away_team_goals INTEGER NOT NULL,
    home_team_id INTEGER NOT NULL,
    away_team_id INTEGER NOT NULL,
    competition_id INTEGER NOT NULL,
    FOREIGN KEY (home_team_id) REFERENCES teams(id_team),
    FOREIGN KEY (away_team_id) REFERENCES teams(id_team),
    FOREIGN KEY (competition_id) REFERENCES competitions(id_competition)
);

INSERT INTO teams(name_team)
	VALUES("América Mineiro"),
    ("Atlético Goianiense"),
    ("Athletico Paranaense"),
    ("Atlético Mineiro"),
    ("Bahia"),
    ("Botafogo"),
    ("Bragantino"),
    ("Corinthians"),
    ("Coritiba"),
    ("Cuiabá"),
    ("Ceará"),
    ("Chapecoense"),
    ("Criciúma"),
    ("Cruzeiro"),
    ("Flamengo"),
    ("Fluminense"),
    ("Fortaleza"),
    ("Figueirense"),
    ("Grêmio"),
    ("Goiás"),
    ("Internacional"),
    ("Joinville"),
    ("Juventude"),
    ("Operário-PR"),
    ("Oeste"),
    ("Palmeiras"),
    ("Paraná Clube"),
    ("Ponte Preta"),
    ("São Paulo"),
    ("Santos"),
    ("Sport"),
    ("Vitória");

INSERT INTO players(name_player, team_id)
	VALUES("Fernandinho", 3),
    ("Soteldo", 19),
    ("Raphael Veiga", 26),
    ("Dudu", 26),
    ("Gabriel Barbosa", 14),
    ("Cássio", 14),
    ("Tiquinho Soares", 6),
    ("Junior Santos", 6),
    ("Luiz Henrique", 6),
    ("Marinho", 17),
    ("Arrascaeta", 15),
    ("Yago PiKachu", 17),
    ("Bolasie", 13),
    ("Lucas Moura", 29),
    ("Alan Patrick", 21),
    ("Índio", 24),
    ("Walter", 10),
    ("Benítez", 1),
    ("Matheuzinho", 32),
    ("Gil", 30),
    ("Lindoso", 24),
    ("Braithwite", 19),
    ("Perotti", 12),
    ("Cano", 16),
    ("Ruan Carneiro", 18),
    ("Ipita", 10),
    ("Wesley", 21),
    ("Nestor", 29),
    ("Guilherme Cachoeira", 22),
    ("Gerson", 15),
    ("Lucas Lima", 31);