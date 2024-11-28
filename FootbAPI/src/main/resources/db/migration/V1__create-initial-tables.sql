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