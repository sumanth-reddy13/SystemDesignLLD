package org.example.CricbuzzDesign.State;

import org.example.CricbuzzDesign.Entity.Ball;
import org.example.CricbuzzDesign.Entity.Match;

public class ScheduledState implements MatchState {

    @Override
    public void processBall(Match match, Ball ball) {
        System.out.println("Ball can't be processed in Scheduled State.");
    }

    @Override
    public void startNextInnings(Match match) {
        /** if only valid innings.
                add a new innings.
                change currentState
                change MatchState
         */
    }
}
