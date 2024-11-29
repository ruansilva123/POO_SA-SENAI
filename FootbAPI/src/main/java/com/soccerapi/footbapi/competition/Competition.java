package com.soccerapi.footbapi.competition;

import jakarta.persistence.*;

@Entity
@Table(name = "competitions")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompetition;
    private String nameCompetition;

    public Long getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(Long idCompetition) {
        this.idCompetition = idCompetition;
    }

    public String getNameCompetition() {
        return nameCompetition;
    }

    public void setNameCompetition(String nameCompetition) {
        this.nameCompetition = nameCompetition;
    }

    public Competition(Long idCompetition, String nameCompetition) {
        this.idCompetition = idCompetition;
        this.nameCompetition = nameCompetition;
    }

    public Competition() {
    }
}
