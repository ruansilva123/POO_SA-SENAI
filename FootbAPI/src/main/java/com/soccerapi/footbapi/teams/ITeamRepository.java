package com.soccerapi.footbapi.teams;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamRepository extends JpaRepository<Team, Long> {
    
}
