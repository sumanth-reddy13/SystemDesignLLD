package org.example.CricbuzzDesign.State;

import org.example.CricbuzzDesign.Entity.Ball;
import org.example.CricbuzzDesign.Entity.Match;

public interface MatchState {

    public void processBall(Match match, Ball ball);

    default void startNextInnings(Match match) {
        System.out.println("Next Innings can't be started in this State.");
    }
}
