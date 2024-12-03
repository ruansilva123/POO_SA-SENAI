package com.soccerapi.footbapi.match;

import com.soccerapi.footbapi.competition.Competition;
import com.soccerapi.footbapi.team.Team;

import java.util.Date;

public class MatchDTO {
    private Long id;
    private Date dateMatch;
    private int homeTeamGols;
    private int awayTeamGols;
    private Long competition;
    private Long homeTeam;
    private Long awayTeam;

    public MatchDTO() {
    }

    public MatchDTO(Long id, Date dateMatch, int homeTeamGols, int awayTeamGols, Long competition, Long homeTeam, Long awayTeam) {
        this.id = id;
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

    public Long getCompetition() {
        return competition;
    }

    public void setCompetition(Long competition) {
        this.competition = competition;
    }

    public Long getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Long homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Long getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Long awayTeam) {
        this.awayTeam = awayTeam;
    }
}
