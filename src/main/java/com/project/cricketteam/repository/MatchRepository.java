package com.project.cricketteam.repository;

import com.project.cricketteam.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MatchRepository extends JpaRepository<Match, Long> {
    // You can add custom query methods if needed
}
