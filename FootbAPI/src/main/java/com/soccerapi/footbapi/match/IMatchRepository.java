package com.soccerapi.footbapi.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatchRepository extends JpaRepository<Match, Long> {
}
