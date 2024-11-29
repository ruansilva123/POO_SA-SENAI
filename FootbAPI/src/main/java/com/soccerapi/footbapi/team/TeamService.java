package com.soccerapi.footbapi.team;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamService {

    @Autowired
    ITeamRepository teamRepository;

    public TeamDTO createTeam(TeamDTO teamDTO){
        Team team = teamRepository.save(TeamMapper.toTeam(teamDTO));
        return TeamMapper.toDTO(team);
    }

    public List<TeamDTO> readTeams(){
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(TeamMapper::toDTO).collect(Collectors.toList());
    }

    public List<TeamDTO> readTeamByName(String nameTeam){
        List<Team> teams = teamRepository.searchByNameTeamContaining(nameTeam);
        return teams.stream().map(TeamMapper::toDTO).collect(Collectors.toList());
    }

    public TeamDTO editTeam(Long id, TeamDTO teamDTO){
        TeamDTO existTeam =  TeamMapper.toDTO(teamRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new));

        existTeam.setNameTeam(teamDTO.getNameTeam());
        System.out.println("Nome do time: "+existTeam.getNameTeam());
        teamRepository.save(TeamMapper.toTeam(existTeam));
        return existTeam;
    }

    public void deleteTeam(Long id) {
       if(!teamRepository.existsById(id)){
            throw new EntityExistsException("Team not found!");
       }
       teamRepository.deleteById(id);
    }
}
