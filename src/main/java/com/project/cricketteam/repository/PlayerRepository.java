package com.project.cricketteam.repository;

import com.project.cricketteam.entity.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Players, Long> {

    List<Players> findAll();
    List<Players> findByAverageGreaterThanOrderByDateOfBirthDesc(Double average);

    List<Players> findByCountry(String country);

    List<Players> findByIdAndAverageGreaterThan(Long id, Double average);

    @Query("SELECT p.name FROM Players p WHERE p.match.id = :matchId")
    List<String> findPlayersNamesByMatchId(@Param("matchId") Long matchId);
}
