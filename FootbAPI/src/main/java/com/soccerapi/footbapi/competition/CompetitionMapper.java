package com.soccerapi.footbapi.competition;

public class CompetitionMapper {

    public static CompetitionDTO toDTO(Competition competition){
        return new CompetitionDTO(
          competition.getIdCompetition(),
          competition.getNameCompetition()
        );
    }

    public static Competition toCompetion(CompetitionDTO competitionDTO){
        return new Competition(
          competitionDTO.getIdCompetition(),
          competitionDTO.getNameCompetition()
        );
    }
}
