package com.project.cricketteam.service;

import com.project.cricketteam.entity.Players;
import com.project.cricketteam.repository.PlayerRepository;
import com.project.cricketteam.service.PlayerService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePlayer() {
        Players playerToCreate = new Players(null, "John Doe", LocalDate.of(1990, 5, 15), "Australia");
        when(playerRepository.save(playerToCreate)).thenReturn(new Players(1L, "John Doe", LocalDate.of(1990, 5, 15), "Australia"));

        Players createdPlayer = playerService.createPlayer(playerToCreate);

        assertNotNull(createdPlayer.getId());
        assertEquals("John Doe", createdPlayer.getName());
        assertEquals(LocalDate.of(1990, 5, 15), createdPlayer.getDateOfBirth());
        assertEquals("Australia", createdPlayer.getCountry());

        verify(playerRepository, times(1)).save(playerToCreate);
    }

    @Test
    void testUpdatePlayer() {
        Long playerId = 1L;
        Players existingPlayer = new Players(playerId, "John Doe", LocalDate.of(1990, 5, 15), "Australia");
        when(playerRepository.findById(playerId)).thenReturn(Optional.of(existingPlayer));

        Players updatedPlayer = new Players(null, "Updated Name", LocalDate.of(1995, 8, 22), "England");
        when(playerRepository.save(existingPlayer)).thenReturn(updatedPlayer);

        Players result = playerService.updatePlayer(playerId, updatedPlayer);

        assertEquals(playerId, result.getId());
        assertEquals("Updated Name", result.getName());
        assertEquals(LocalDate.of(1995, 8, 22), result.getDateOfBirth());
        assertEquals("England", result.getCountry());

        verify(playerRepository, times(1)).findById(playerId);
        verify(playerRepository, times(1)).save(existingPlayer);
    }

    @Test
    void testUpdatePlayer_PlayerNotFound() {
        Long playerId = 1L;
        when(playerRepository.findById(playerId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> playerService.updatePlayer(playerId, new Players()));

        verify(playerRepository, times(1)).findById(playerId);
        verify(playerRepository, never()).save(any());
    }

    @Test
    void testDeletePlayer() {
        Long playerId = 1L;

        assertDoesNotThrow(() -> playerService.deletePlayer(playerId));

        verify(playerRepository, times(1)).deleteById(playerId);
    }

    @Test
    void testGetPlayerById() {
        Long playerId = 1L;
        Players existingPlayer = new Players(playerId, "John Doe", LocalDate.of(1990, 5, 15), "Australia");
        when(playerRepository.findById(playerId)).thenReturn(Optional.of(existingPlayer));

        Players result = playerService.getPlayerById(playerId);

        assertEquals(playerId, result.getId());
        assertEquals("John Doe", result.getName());
        assertEquals(LocalDate.of(1990, 5, 15), result.getDateOfBirth());
        assertEquals("Australia", result.getCountry());

        verify(playerRepository, times(1)).findById(playerId);
    }

    @Test
    void testGetPlayerById_PlayerNotFound() {
        Long playerId = 1L;
        when(playerRepository.findById(playerId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> playerService.getPlayerById(playerId));

        verify(playerRepository, times(1)).findById(playerId);
    }
}
