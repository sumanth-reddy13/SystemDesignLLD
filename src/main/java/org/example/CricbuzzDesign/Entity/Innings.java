package org.example.CricbuzzDesign.Entity;

import java.util.List;
import java.util.Map;

public class Innings {
    private Team battingTeam;
    private Team bowlingTeam;
    private int score;
    private int wickets;
    private int extras;
    private List<Ball> balls;
    private Map<Player, PlayerStats> playerStats;
    private double overs;

    public void addBall(Ball ball) { this.balls.add(ball); }
    public List<Ball> getBalls() { return this.balls; }
    public Map<Player, PlayerStats> getPlayerStats() { return this.playerStats; }
    public int getScore() { return this.score; }
    public int getWickets() { return this.wickets; }
    public int getExtras() { return this.extras; }
    public double getOvers() { return this.overs; }
    public Team getBattingTeam() { return this.battingTeam; }
    public Team getBowlingTeam() { return this.bowlingTeam; }
    public void updateScore(int runs) {
        this.score += runs;
    }

    public void incrementWickets() {
        this.wickets++;
    }

    public void updateExtras(int extraRuns) {
        this.extras += extraRuns;
    }

}
