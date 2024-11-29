package com.soccerapi.footbapi.team;

import jakarta.persistence.Entity;

public class TeamDTO {

    private Long id;
    private String nameTeam;

    public TeamDTO() {
    }

    public TeamDTO(Long id, String nameTeam) {
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
