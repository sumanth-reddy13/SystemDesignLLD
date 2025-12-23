package org.example.CricbuzzDesign.State;

import org.example.CricbuzzDesign.Entity.Ball;
import org.example.CricbuzzDesign.Entity.Match;

public class InBreakState implements MatchState {

    public void processBall(Match match, Ball ball) {
        System.out.println("Ball can't be processed in Break State. ");
    }

    public void startNextInnings(Match match) {
        // TODO Add logic to start next Innings.
    }
}
