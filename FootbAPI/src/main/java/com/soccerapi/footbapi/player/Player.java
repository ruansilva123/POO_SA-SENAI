package com.soccerapi.footbapi.player;

import com.soccerapi.footbapi.team.Team;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namePlayer;

    @ManyToOne(cascade = CascadeType.ALL)
    private Team team;

    public Player() {
    }

    public Player(Long id, String namePlayer, Team team) {
        this.id = id;
        this.namePlayer = namePlayer;
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
