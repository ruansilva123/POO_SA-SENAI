package com.soccerapi.footbapi.player;

import com.soccerapi.footbapi.team.ITeamRepository;
import com.soccerapi.footbapi.team.Team;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    ITeamRepository teamRepository;

    @Autowired
    IPlayerRepository playerRepository;

    public PlayerDTO createPlayer(PlayerDTO playerDTO){
        Team team = teamRepository.findById(playerDTO.getTeam())
                        .orElseThrow(() -> new EntityNotFoundException("Team not found!"));

        Player player = playerRepository.save(PlayerMapper.toPlayer(playerDTO, team));
        return PlayerMapper.toDTO(player);
    }

    public List<Player> readPlayers(){
        return playerRepository.findAll();
    }

    public PlayerDTO readPlayer(Long id){
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found!"));

        return PlayerMapper.toDTO(player);
    }
}
