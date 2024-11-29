package com.soccerapi.footbapi.team;

public class TeamMapper {

    public static TeamDTO toDTO(Team team){
        return new TeamDTO(
                team.getId(),
                team.getNameTeam()
        );
    }

    public static Team toTeam(TeamDTO teamDTO){
        return new Team(
                teamDTO.getId(),
                teamDTO.getNameTeam()
        );
    }
}