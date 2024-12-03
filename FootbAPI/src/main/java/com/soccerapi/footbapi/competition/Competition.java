package com.soccerapi.footbapi.competition;

import com.soccerapi.footbapi.match.Match;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "competitions")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompetition;
    private String nameCompetition;

    @OneToMany(mappedBy = "competition")
    private List<Match> matchList;

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
