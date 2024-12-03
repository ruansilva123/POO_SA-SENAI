package com.soccerapi.footbapi.match;

import com.soccerapi.footbapi.competition.Competition;
import com.soccerapi.footbapi.team.Team;
import org.springframework.beans.factory.annotation.Autowired;

public class MatchMapper {
    @Autowired
    IMatchRepository iMatchRepository;

    public static MatchDTO toDTO(Match match){
        return new MatchDTO(
                match.getId(),
                match.getDateMatch(),
                match.getHomeTeamGols(),
                match.getAwayTeamGols(),
                match.getCompetition().getIdCompetition(),
                match.getHomeTeam().getId(),
                match.getAwayTeam().getId()
        );
    }

    public static Match toMatch(MatchDTO matchDTO, Competition competition, Team homeTeam, Team awayTeam){
        return new Match(
                matchDTO.getDateMatch(),
                matchDTO.getHomeTeamGols(),
                matchDTO.getAwayTeamGols(),
                competition,
                homeTeam,
                awayTeam
        );
    }
}
