package com.project.cricketteam.service;

import com.project.cricketteam.entity.Match;
import com.project.cricketteam.repository.MatchRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    public Match updateMatch(Long id, Match updatedMatch) {
        Match existingMatch = matchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match not found"));

        // Update match details
        existingMatch.setScore(updatedMatch.getScore());
        existingMatch.setStadium(updatedMatch.getStadium());

        return matchRepository.save(existingMatch);
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }

    public Match getMatchById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match not found"));
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }
}
