package com.soccerapi.footbapi.match;

import com.soccerapi.footbapi.competition.Competition;
import com.soccerapi.footbapi.competition.ICompetitionRepository;
import com.soccerapi.footbapi.team.ITeamRepository;
import com.soccerapi.footbapi.team.Team;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    @Autowired
    IMatchRepository iMatchRepository;

    @Autowired
    ITeamRepository iTeamRepository;

    @Autowired
    ICompetitionRepository iCompetitionRepository;

    public MatchDTO createMatch(MatchDTO matchDTO){
        Team homeTeam = iTeamRepository.findById(matchDTO.getHomeTeam())
                .orElseThrow(() -> new EntityNotFoundException("Home team not found!"));
        Team awayTeam = iTeamRepository.findById(matchDTO.getAwayTeam())
                .orElseThrow(() -> new EntityNotFoundException("Away team not found!"));
        Competition competition = iCompetitionRepository.findById(matchDTO.getCompetition())
                .orElseThrow(() -> new EntityNotFoundException("Competition not found!"));
        Match match = iMatchRepository.save(MatchMapper.toMatch(matchDTO, competition, homeTeam, awayTeam));
        return MatchMapper.toDTO(match);
    }

    public List<Match> readMatches(){ return iMatchRepository.findAll(); }

    public MatchDTO readMatch(Long id){
        Match match = iMatchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match not found!"));

        return MatchMapper.toDTO(match);
    }

    public MatchDTO editMatch(Long id, MatchDTO matchDTO){

        Match match = iMatchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match not found!"));
        Team homeTeam = iTeamRepository.findById(matchDTO.getHomeTeam())
                .orElseThrow(() -> new EntityNotFoundException("Home team not found!"));
        Team awayTeam = iTeamRepository.findById(matchDTO.getAwayTeam())
                .orElseThrow(() -> new EntityNotFoundException("Away team not found!"));
        Competition competition = iCompetitionRepository.findById(matchDTO.getCompetition())
                .orElseThrow(() -> new EntityNotFoundException("Competition not found!"));

        match.setDateMatch(matchDTO.getDateMatch());
        match.setHomeTeamGols(matchDTO.getHomeTeamGols());
        match.setAwayTeamGols(match.getAwayTeamGols());
        match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);
        match.setCompetition(competition);

        iMatchRepository.save(match);
        return MatchMapper.toDTO(match);
    }

    public void deleteMatch(Long id){
        if(!iMatchRepository.existsById(id)){
            throw new EntityExistsException("Match not found!");
        }
        iMatchRepository.deleteById(id);
    }
}
