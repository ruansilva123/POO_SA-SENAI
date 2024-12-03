package com.soccerapi.footbapi.match;

import com.soccerapi.footbapi.competition.Competition;
import com.soccerapi.footbapi.team.Team;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateMatch;
    private int homeTeamGols;
    private int awayTeamGols;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Competition competition;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Team homeTeam;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Team awayTeam;

    public Match() {
    }

    public Match(Date dateMatch, int homeTeamGols, int awayTeamGols, Competition competition, Team homeTeam, Team awayTeam) {
        this.dateMatch = dateMatch;
        this.homeTeamGols = homeTeamGols;
        this.awayTeamGols = awayTeamGols;
        this.competition = competition;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(Date dateMatch) {
        this.dateMatch = dateMatch;
    }

    public int getHomeTeamGols() {
        return homeTeamGols;
    }

    public void setHomeTeamGols(int homeTeamGols) {
        this.homeTeamGols = homeTeamGols;
    }

    public int getAwayTeamGols() {
        return awayTeamGols;
    }

    public void setAwayTeamGols(int awayTeamGols) {
        this.awayTeamGols = awayTeamGols;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }
}