package com.soccerapi.footbapi.player;

import com.soccerapi.footbapi.team.ITeamRepository;
import com.soccerapi.footbapi.team.Team;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PlayerMapper {

    @Autowired
    ITeamRepository teamRepository;

    public static PlayerDTO toDTO(Player player){
        return new PlayerDTO(
                player.getId(),
                player.getNamePlayer(),
                player.getTeam().getId()
        );
    }

    public static Player toPlayer(PlayerDTO playerDTO, Team team){
        return new Player(
                playerDTO.getId(),
                playerDTO.getNamePlayer(),
                team
        );
    }
}
