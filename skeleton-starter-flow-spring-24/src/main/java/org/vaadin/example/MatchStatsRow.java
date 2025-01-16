package org.vaadin.example;

public class MatchStatsRow {
    private String date;
    private String matchId;
    private String team1Goals;
    private String team2Goals;
    private String team1Possession;
    private String team2Possession;
    private String team1Passes;
    private String team2Passes;
    private String team1Shots;
    private String team2Shots;
    private String team1ShotsOnTarget;
    private String team2ShotsOnTarget;
    private String team1Corners;
    private String team2Corners;

    public MatchStatsRow(String date, String matchId, String team1Goals, String team2Goals,
            String team1Possession, String team2Possession, String team1Passes, String team2Passes,
            String team1Shots, String team2Shots, String team1ShotsOnTarget, String team2ShotsOnTarget,
            String team1Corners, String team2Corners) {
        this.date = date;
        this.matchId = matchId;
        this.team1Goals = team1Goals;
        this.team2Goals = team2Goals;
        this.team1Possession = team1Possession;
        this.team2Possession = team2Possession;
        this.team1Passes = team1Passes;
        this.team2Passes = team2Passes;
        this.team1Shots = team1Shots;
        this.team2Shots = team2Shots;
        this.team1ShotsOnTarget = team1ShotsOnTarget;
        this.team2ShotsOnTarget = team2ShotsOnTarget;
        this.team1Corners = team1Corners;
        this.team2Corners = team2Corners;
    }

    public String getDate() {
        return date;
    }

    public String getMatchId() {
        return matchId;
    }

    public String getTeam1Goals() {
        return team1Goals;
    }

    public String getTeam2Goals() {
        return team2Goals;
    }

    public String getTeam1Possession() {
        return team1Possession;
    }

    public String getTeam2Possession() {
        return team2Possession;
    }

    public String getTeam1Passes() {
        return team1Passes;
    }

    public String getTeam2Passes() {
        return team2Passes;
    }

    public String getTeam1Shots() {
        return team1Shots;
    }

    public String getTeam2Shots() {
        return team2Shots;
    }

    public String getTeam1ShotsOnTarget() {
        return team1ShotsOnTarget;
    }

    public String getTeam2ShotsOnTarget() {
        return team2ShotsOnTarget;
    }

    public String getTeam1Corners() {
        return team1Corners;
    }

    public String getTeam2Corners() {
        return team2Corners;
    }
}
