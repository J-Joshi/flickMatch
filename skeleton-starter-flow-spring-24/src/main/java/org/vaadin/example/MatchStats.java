package org.vaadin.example;

import java.util.Map;

public class MatchStats {
    private String matchId;
    private String date;
    private Map<String, TeamStats> stats;

    // Getters and Setters
    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, TeamStats> getStats() {
        return stats;
    }

    public void setStats(Map<String, TeamStats> stats) {
        this.stats = stats;
    }
}
