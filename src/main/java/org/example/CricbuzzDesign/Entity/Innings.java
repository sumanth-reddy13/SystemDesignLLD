package org.example.CricbuzzDesign.Entity;

import org.example.CricbuzzDesign.enums.ExtraType;

import java.util.ArrayList;
import java.util.HashMap;
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

    public Innings(Team battingTeam, Team bowlingTeam) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.playerStats = new HashMap<>();

        for (Player player : battingTeam.getPlayers()) {
            playerStats.put(player, new PlayerStats());
        }

        for (Player player : bowlingTeam.getPlayers()) {
            playerStats.put(player, new PlayerStats());
        }

        this.balls = new ArrayList<>();
        this.overs = 0.0;
    }

    public void addBall(Ball ball) { this.balls.add(ball); }
    public List<Ball> getBalls() { return this.balls; }
    public Map<Player, PlayerStats> getPlayerStats() { return this.playerStats; }
    public int getScore() { return this.score; }
    public int getWickets() { return this.wickets; }
    public int getExtras() { return this.extras; }
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

    public double getOvers() {
        int validBalls = (int) balls.stream()
                .filter(ball -> ball.getExtraType() != ExtraType.NO_BALL || ball.getExtraType() != ExtraType.WIDE)
                .count();

        int completedOvers = validBalls / 6;
        int ballsInOver = validBalls % 6;

        return completedOvers + ballsInOver;
    }
}
