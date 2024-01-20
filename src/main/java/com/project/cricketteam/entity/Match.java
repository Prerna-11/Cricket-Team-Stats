package com.project.cricketteam.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int score;
    private String stadium;

    @OneToMany(mappedBy = "match")
    private List<Players> players;

}
