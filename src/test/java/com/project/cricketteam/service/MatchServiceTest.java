package com.project.cricketteam.service;

import com.project.cricketteam.entity.Match;
import com.project.cricketteam.repository.MatchRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class MatchServiceTest {

    @Mock
    private MatchRepository matchRepository;

    @InjectMocks
    private MatchService matchService;

    @Test
    void getAllMatches() {
        MockitoAnnotations.openMocks(this);

        // Mocking the repository behavior
        Match match1 = new Match();
        match1.setId(1L);
        match1.setScore(200);
        match1.setStadium("Stadium 1");

        Match match2 = new Match();
        match2.setId(2L);
        match2.setScore(150);
        match2.setStadium("Stadium 2");

        List<Match> mockMatches = Arrays.asList(match1, match2);

        when(matchRepository.findAll()).thenReturn(mockMatches);

        // Calling the service method
        List<Match> result = matchService.getAllMatches();

        // Assertions
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals(2L, result.get(1).getId());
    }
}
