package com.soccerapi.footbapi.competition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompetitionRepository extends JpaRepository<Competition, Long> {

    List<Competition> findByNameCompetitionStartingWith(String nameCompetition);
}
