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
        Competition competition = iCompetitionRepository.save(CompetitionMapper.toCompetition(competitionDTO));
        return CompetitionMapper.toDTO(competition);
    }

    public List<CompetitionDTO> readCompetitions(){
        List<Competition> competitions = iCompetitionRepository.findAll();
        return competitions.stream().map(CompetitionMapper::toDTO).collect(Collectors.toList());
    }

    public CompetitionDTO readCompetition(Long competitionId){
        Competition competition = iCompetitionRepository.findById(competitionId)
                .orElseThrow(() -> new EntityNotFoundException("Competition not found!"));
        return CompetitionMapper.toDTO(competition);
    }

    public List<CompetitionDTO> searchByCompetitionName(String competitionName){
        List<Competition> competitions = iCompetitionRepository
                .searchNameCompetition(competitionName);
        return competitions.stream().map(CompetitionMapper::toDTO).collect(Collectors.toList());
    }

    public void deleteCompetition(Long competitionId){
        if(!iCompetitionRepository.existsById(competitionId)){
            throw new EntityNotFoundException("Competition not found!");
        }
        iCompetitionRepository.deleteById(competitionId);
    }

    public CompetitionDTO updateCompetition(Long competitionId, CompetitionDTO futureCompetition){
        Competition competition = iCompetitionRepository.findById(competitionId)
                .orElseThrow(() -> new EntityNotFoundException("Competition not found!"));
        competition.setNameCompetition(futureCompetition.getNameCompetition());
        competition = iCompetitionRepository.save(competition);
        return CompetitionMapper.toDTO(competition);
    }
}
