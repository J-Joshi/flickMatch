package com.xff.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class MatchStatsController {

    @GetMapping("/getMatchStats")
    public Map<String, Object> getMatchStats(@RequestParam String matchId) {
        Map<String, Object> response = new HashMap<>();
        response.put("matchId", matchId);
        response.put("date", "03-05-2023");

        Map<String, Object> stats = new HashMap<>();
        Map<String, String> teamA = new HashMap<>();
        teamA.put("goals", "1");
        teamA.put("possession", "50%");
        teamA.put("passes", "50");
        teamA.put("shots", "5");
        teamA.put("shotsOnTarget", "3");
        teamA.put("corners", "6");

        Map<String, String> teamB = new HashMap<>();
        teamB.put("goals", "1");
        teamB.put("possession", "50%");
        teamB.put("passes", "50");
        teamB.put("shots", "5");
        teamB.put("shotsOnTarget", "3");
        teamB.put("corners", "6");

        stats.put("teamA", teamA);
        stats.put("teamB", teamB);

        response.put("stats", stats);
        return response;
    }
}
