package com.soccerapi.footbapi.team;

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

    public void deleteTeam(Long id){
        teamRepository.deleteById(id);
    }

    public TeamDTO editTeam(Long id, TeamDTO teamDTO){
        Optional<TeamDTO> existTeam =  TeamMapper.toDTO(teamRepository.findById(id))
                .orElseThrow(() -> new EntityNotFoundException());

        if(existTeam.isPresent()){
            Team team = TeamMapper.toTeam(existTeam.get());
            team.setId(teamDTO.getId());
            team.setNameTeam(teamDTO.getNameTeam());
        }
    }
}
