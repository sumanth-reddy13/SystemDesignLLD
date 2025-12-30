package org.example.CricbuzzDesign.State;

import org.example.CricbuzzDesign.Entity.Ball;
import org.example.CricbuzzDesign.Entity.Innings;
import org.example.CricbuzzDesign.Entity.Match;
import org.example.CricbuzzDesign.enums.MatchStatus;

public class InBreakState implements MatchState {

    public void processBall(Match match, Ball ball) {
        System.out.println("Ball can't be processed in Break State.");
    }

    public void startNextInnings(Match match) {
        if (match.getInnings().size() < match.getMatchStrategy().getInnings()) {
            match.getInnings().add(new Innings(match.getTeamB(), match.getTeamA()));
            match.setCurrentState(MatchStatus.LIVE_STATE);
            match.setMatchState(new LiveState());
        }
    }
}
