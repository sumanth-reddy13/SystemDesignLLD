package org.example.CricbuzzDesign;

import org.example.CricbuzzDesign.Entity.*;
import org.example.CricbuzzDesign.Observer.CommentaryDisplay;
import org.example.CricbuzzDesign.Observer.ScorecardDisplay;
import org.example.CricbuzzDesign.Strategy.T20MatchFormatStrategy;
import org.example.CricbuzzDesign.enums.Country;
import org.example.CricbuzzDesign.enums.PlayerRole;
import org.example.CricbuzzDesign.enums.WicketType;

import java.util.List;

public class CricbuzzDemo {
    public static void main(String[] args) {
        CricbuzzService cricbuzzService = CricbuzzService.getInstance();

        Player p1 = new Player.PlayerBuilder().playerId(1).playerName("Virat Kohli").playerCountry(Country.INDIA).playerRole(PlayerRole.BATSMAN).build();
        Player p2 = new Player.PlayerBuilder().playerId(2).playerName("Rohit Sharma").playerCountry(Country.INDIA).playerRole(PlayerRole.BATSMAN).build();
        Player p3 = new Player.PlayerBuilder().playerId(3).playerName("Ravi Jadeja").playerCountry(Country.INDIA).playerRole(PlayerRole.ALL_ROUNDER).build();
        Player p4 = new Player.PlayerBuilder().playerId(4).playerName("Arshdeep Singh").playerCountry(Country.INDIA).playerRole(PlayerRole.BOWLER).build();

        cricbuzzService.createPlayer(p1);cricbuzzService.createPlayer(p2);
        cricbuzzService.createPlayer(p3);cricbuzzService.createPlayer(p4);

        Team t1 = new Team("INDIA", List.of(p1, p2, p3, p4));

        Player p5 = new Player.PlayerBuilder().playerId(1).playerName("David Warner").playerCountry(Country.AUSTRALIA).playerRole(PlayerRole.BATSMAN).build();
        Player p6 = new Player.PlayerBuilder().playerId(2).playerName("Steven Smith").playerCountry(Country.AUSTRALIA).playerRole(PlayerRole.BATSMAN).build();
        Player p7 = new Player.PlayerBuilder().playerId(3).playerName("Mitch Marsh").playerCountry(Country.AUSTRALIA).playerRole(PlayerRole.ALL_ROUNDER).build();
        Player p8 = new Player.PlayerBuilder().playerId(4).playerName("Pat Cummins").playerCountry(Country.AUSTRALIA).playerRole(PlayerRole.BOWLER).build();

        cricbuzzService.createPlayer(p5);cricbuzzService.createPlayer(p6);
        cricbuzzService.createPlayer(p7);cricbuzzService.createPlayer(p8);

        Team t2 = new Team("AUSTRALIA", List.of(p5, p6, p7, p8));

        Match indVsAus = cricbuzzService.createMatch(t1, t2, new T20MatchFormatStrategy(), t1, "TAILS");

        CommentaryDisplay commentaryDisplay = new CommentaryDisplay();
        ScorecardDisplay scorecardDisplay = new ScorecardDisplay();
//        indVsAus.addObserver(commentaryDisplay);
        indVsAus.addObserver(scorecardDisplay);

        cricbuzzService.startMatch(indVsAus);

        indVsAus.processBall(new Ball.BallBuilder()
                            .playedBy(p1)
                            .bowledBy(p8)
                            .withRuns(4).build());

        indVsAus.processBall(new Ball.BallBuilder().playedBy(p1).bowledBy(p8)
                                    .withWicket(new Wicket.WicketBuilder().wicketType(WicketType.BOWLED)
                                    .playerOut(p1).build()).build());

        indVsAus.processBall(new Ball.BallBuilder().playedBy(p2).bowledBy(p7)
                                    .withRuns(2).build());

        indVsAus.processBall(new Ball.BallBuilder().playedBy(p2).bowledBy(p7)
                .withWicket(new Wicket.WicketBuilder().wicketType(WicketType.BOWLED)
                        .playerOut(p2).build()).build());

        indVsAus.processBall(new Ball.BallBuilder().playedBy(p3).bowledBy(p7)
                .withWicket(new Wicket.WicketBuilder().wicketType(WicketType.BOWLED)
                        .playerOut(p3).build()).build());

        System.out.println("INNINGS BREAK!");
        indVsAus.startNextInnings(indVsAus);

        indVsAus.processBall(new Ball.BallBuilder()
                .playedBy(p5)
                .bowledBy(p4)
                .withRuns(4).build());

        indVsAus.processBall(new Ball.BallBuilder()
                .playedBy(p5)
                .bowledBy(p4)
                .withRuns(4).build());

        indVsAus.processBall(new Ball.BallBuilder()
                .playedBy(p5)
                .bowledBy(p4)
                .withRuns(4).build());

        System.out.println(indVsAus.getResult());
    }
}
