package com.soccerapi.footbapi.competition;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetitionService {

    @Autowired
    ICompetitionRepository iCompetitionRepository;

    public CompetitionDTO createCompetition(CompetitionDTO competitionDTO){
        Competition competition = iCompetitionRepository.save(CompetitionMapper.toCompetion(competitionDTO));
        return CompetitionMapper.toDTO(competition);
    }

    public List<CompetitionDTO> readCompetitions(){
        List<Competition> competitions = iCompetitionRepository.findAll();
        return competitions.stream().map(CompetitionMapper::toDTO).collect(Collectors.toList());
    }

    public CompetitionDTO readCompetition(Long competition_id){
        Competition competition = iCompetitionRepository.findById(competition_id)
                .orElseThrow(() -> new EntityNotFoundException("Competition not found!"));
        return CompetitionMapper.toDTO(competition);
    }

    public List<CompetitionDTO> searchByCompetitionName(String competitionName){
        List<Competition> competitions = iCompetitionRepository
                .searchNameCompetition(competitionName);
        return competitions.stream().map(CompetitionMapper::toDTO).collect(Collectors.toList());
    }

    public void deleteCompetition(CompetitionDTO competitionDTO){
        iCompetitionRepository.delete(CompetitionMapper.toCompetion(competitionDTO));
    }

    public CompetitionDTO updateCompetition(CompetitionDTO currentCompetition, CompetitionDTO futureCompetition){
        Competition competition = CompetitionMapper.toCompetion(currentCompetition);
        competition.setNameCompetition(futureCompetition.getNameCompetition());
        competition = iCompetitionRepository.save(competition);
        return CompetitionMapper.toDTO(competition);
    }
}
