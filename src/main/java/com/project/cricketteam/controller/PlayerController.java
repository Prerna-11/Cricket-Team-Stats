package com.project.cricketteam.controller;

import com.project.cricketteam.entity.Players;
import com.project.cricketteam.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<Players> createPlayer(@RequestBody Players player) {
        Players createdPlayer = playerService.createPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Players>> getAllPlayers() {
        List<Players> allPlayers = playerService.getAllPlayers();
        return new ResponseEntity<>(allPlayers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Players> updatePlayer(@PathVariable Long id, @RequestBody Players updatedPlayer) {
        Players updated = playerService.updatePlayer(id, updatedPlayer);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Players> getPlayerById(@PathVariable Long id) {
        Players player = playerService.getPlayerById(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @GetMapping("/averageGreaterThan/{average}")
    public ResponseEntity<List<Players>> getPlayersWithAverageGreaterThan(@PathVariable Double average) {
        List<Players> players = playerService.getPlayersWithAverageGreaterThan(average);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<Players>> getPlayersByCountry(@PathVariable String country) {
        List<Players> players = playerService.getPlayersByCountry(country);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/sortedByAverage/{average}")
    public ResponseEntity<List<Players>> getPlayersSortedByAverage(@PathVariable Double average) {
        List<Players> players = playerService.getPlayersSortedByAverage(average);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/match/{matchId}/players")
    public ResponseEntity<List<String>> getPlayersNamesByMatchId(@PathVariable Long matchId) {
        List<String> playerNames = playerService.getPlayersNamesByMatchId(matchId);
        return new ResponseEntity<>(playerNames, HttpStatus.OK);
    }
}
