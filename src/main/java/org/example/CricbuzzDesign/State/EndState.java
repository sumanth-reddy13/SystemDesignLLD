package org.example.CricbuzzDesign.State;

import org.example.CricbuzzDesign.Entity.Ball;
import org.example.CricbuzzDesign.Entity.Match;

public class EndState implements MatchState {
    public void processBall(Match match, Ball ball) {
        System.out.println("Ball can't be processed in End State.");
    }
}
