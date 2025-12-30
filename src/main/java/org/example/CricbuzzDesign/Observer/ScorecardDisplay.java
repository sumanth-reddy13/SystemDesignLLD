package org.example.CricbuzzDesign.Observer;

import org.example.CricbuzzDesign.Entity.*;
import java.util.List;
import java.util.Map;

public class ScorecardDisplay implements MatchObserver {

    @Override
    public void update(Match match, Ball ball) {
        List<Innings> innings = match.getInnings();
        System.out.println("******** SCORECARD ********");

        // Innings 1
        Innings firstInnings = innings.get(0);
        System.out.println("TEAM : " + firstInnings.getBattingTeam().getName());
        System.out.println("Score : " + firstInnings.getScore());
        System.out.println("Wickets : " + firstInnings.getWickets());
        System.out.println("Overs : " + firstInnings.getOvers());

        System.out.println("******** BATTING STATS ********");
        System.out.println("PLAYER NAME | RUNS  | BALLS FACED");
        Map<Player, PlayerStats> firstInningsPlayerStats = firstInnings.getPlayerStats();
        for (Player player : firstInnings.getBattingTeam().getPlayers()) {
            PlayerStats ps = firstInningsPlayerStats.get(player);
            System.out.println(player.getPlayerName() + " | " + ps.getRuns() + " | " + ps.getBallsFaced());
        }

        System.out.println("******** BOWLING STATS ********");
        System.out.println("PLAYER NAME | WICKETS");
        for (Player player : firstInnings.getBowlingTeam().getPlayers()) {
            PlayerStats ps = firstInningsPlayerStats.get(player);
            System.out.println(player.getPlayerName() + " | " + ps.getWickets());
        }

        // Innings 2
        if (innings.size() == 2) {
            Innings secondInnings = innings.get(1);
            System.out.println("TEAM : " + secondInnings.getBattingTeam().getName());
            System.out.println("Score : " + secondInnings.getScore());
            System.out.println("Wickets : " + secondInnings.getWickets());
            System.out.println("Overs : " + secondInnings.getOvers());

            System.out.println("****** BATTING STATS ******");
            System.out.println("PLAYER NAME | RUNS  | BALLS FACED");
            Map<Player, PlayerStats> secondInningsPlayerStats = secondInnings.getPlayerStats();
            for (Player player : secondInnings.getBattingTeam().getPlayers()) {
                PlayerStats ps = secondInningsPlayerStats.get(player);
                System.out.println(player.getPlayerName() + " | " + ps.getRuns() + " | " + ps.getBallsFaced());
            }

            System.out.println("****** BOWLING STATS ******");
            System.out.println("PLAYER NAME | WICKETS");
            for (Player player : secondInnings.getBowlingTeam().getPlayers()) {
                PlayerStats ps = secondInningsPlayerStats.get(player);
                System.out.println(player.getPlayerName() + " | " + ps.getWickets());
            }
        }
    }
}
