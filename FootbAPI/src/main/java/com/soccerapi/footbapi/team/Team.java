package com.soccerapi.footbapi.team;

import com.soccerapi.footbapi.match.Match;
import com.soccerapi.footbapi.player.Player;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameTeam;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    @OneToMany(mappedBy = "homeTeam")
    private List<Match> homeTeamList;

    @OneToMany(mappedBy = "awayTeam")
    private List<Match> awayTeamList;

    public Team() {
    }

    public Team(Long id, String nameTeam) {
        this.id = id;
        this.nameTeam = nameTeam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }
}
