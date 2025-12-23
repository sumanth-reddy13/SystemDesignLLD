package org.example.CricbuzzDesign.Entity;

public class PlayerStats {
    private int runs;
    private int wickets;
    private int ballsFaced;

    public PlayerStats() {
        this.runs = 0;
        this.wickets = 0;
        this.ballsFaced = 0;
    }

    public void updateRuns(int runsScored) {
        this.runs += runsScored;
    }

    public void updateWickets(int wicketsTaken) {
        this.wickets += wicketsTaken;
    }

    public void updateBallsPlayed(int ballsFaced) {
        this.ballsFaced += ballsFaced;
    }

    public int getRuns() {return this.runs;}
    public int getWickets() {return this.wickets;}
    public int getBallsFaced() {return this.ballsFaced;}
}
