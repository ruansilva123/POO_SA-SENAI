package com.soccerapi.footbapi.competition;

public class CompetitionDTO {

    private Long idCompetition;
    private String nameCompetition;

    public Long getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(Long idCompetition) {
        this.idCompetition = idCompetition;
    }

    public String getNameCompetition() {
        return nameCompetition;
    }

    public void setNameCompetition(String nameCompetition) {
        this.nameCompetition = nameCompetition;
    }

    public CompetitionDTO(Long idCompetition, String nameCompetition) {
        this.idCompetition = idCompetition;
        this.nameCompetition = nameCompetition;
    }

    public CompetitionDTO() {
    }
}
