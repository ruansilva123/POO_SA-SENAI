package com.soccerapi.footbapi.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Long> {
    @Query("SELECT t FROM Team t WHERE t.nameTeam LIKE :nameTeam%")
    List<Team> searchByNameTeamContaining(@Param("nameTeam") String nameTeam);

}
