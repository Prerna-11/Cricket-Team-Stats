package com.project.cricketteam.service;

import com.project.cricketteam.entity.Players;
import com.project.cricketteam.repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;


    public Players createPlayer(Players player) {
        return playerRepository.save(player);
    }

    public List<Players> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Players updatePlayer(Long id, Players updatedPlayer) {
        Players existingPlayer = playerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found"));

        // Update player details
        existingPlayer.setName(updatedPlayer.getName());
        existingPlayer.setDateOfBirth(updatedPlayer.getDateOfBirth());
        existingPlayer.setCountry(updatedPlayer.getCountry());
        existingPlayer.setMatch(updatedPlayer.getMatch());

        return playerRepository.save(existingPlayer);
    }


    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public Players getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found"));
    }

    public List<Players> getPlayersWithAverageGreaterThan(Double average) {
        return playerRepository.findByAverageGreaterThanOrderByDateOfBirthDesc(average);
    }

    public List<Players> getPlayersByCountry(String country) {
        return playerRepository.findByCountry(country);
    }

    public List<Players> getPlayersSortedByAverage(Double average) {
        return playerRepository.findAll(Sort.by(Sort.Order.desc("average"), Sort.Order.asc("dateOfBirth")))
                .stream()
                .filter(player -> player.getAverage() != null && player.getAverage() > average)
                .collect(Collectors.toList());
    }

    public List<String> getPlayersNamesByMatchId(Long matchId) {
        return playerRepository.findPlayersNamesByMatchId(matchId);
    }
}
