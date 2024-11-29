package com.soccerapi.footbapi.teams;

import jakarta.persistence.Entity;

@Entity
public class TeamDTO {

    private Long id;
    private String name_team;

    public TeamDTO() {
    }

    public TeamDTO(Long id, String name_team) {
        this.id = id;
        this.name_team = name_team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_team() {
        return name_team;
    }

    public void setName_team(String name_team) {
        this.name_team = name_team;
    }
}
