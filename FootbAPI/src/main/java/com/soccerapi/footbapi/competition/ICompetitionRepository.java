package com.soccerapi.footbapi.competition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompetitionRepository extends JpaRepository<Competition, Long> {

    @Query("SELECT c FROM Competition c WHERE LOWER(c.nameCompetition) LIKE LOWER(:nameCompetition%)")
    List<Competition> searchNameCompetition(String nameCompetition);
}