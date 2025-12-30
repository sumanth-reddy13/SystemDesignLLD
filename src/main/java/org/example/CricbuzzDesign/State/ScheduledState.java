package org.example.CricbuzzDesign.State;

import org.example.CricbuzzDesign.Entity.Ball;
import org.example.CricbuzzDesign.Entity.Innings;
import org.example.CricbuzzDesign.Entity.Match;
import org.example.CricbuzzDesign.enums.MatchStatus;

public class ScheduledState implements MatchState {

    @Override
    public void processBall(Match match, Ball ball) {
        System.out.println("Ball can't be processed in Scheduled State.");
    }

    public void startNextInnings(Match match) {
        match.getInnings().add(new Innings(match.getTeamA(), match.getTeamB()));
        match.setCurrentState(MatchStatus.LIVE_STATE);
        match.setMatchState(new LiveState());
    }
}
