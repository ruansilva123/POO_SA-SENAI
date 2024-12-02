package com.soccerapi.footbapi.player;

import com.soccerapi.footbapi.team.Team;
import jakarta.persistence.*;

import java.util.List;

public class PlayerDTO {
    private Long id;
    private String namePlayer;
    private Long team;

    public PlayerDTO() {
    }

    public PlayerDTO(Long id, String namePlayer, Long team) {
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

    public Long getTeam() {
        return team;
    }

    public void setTeam(Long team) {
        this.team = team;
    }
}
