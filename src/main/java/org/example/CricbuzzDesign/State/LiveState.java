package org.example.CricbuzzDesign.State;

import org.example.CricbuzzDesign.Entity.Ball;
import org.example.CricbuzzDesign.Entity.Innings;
import org.example.CricbuzzDesign.Entity.Match;
import org.example.CricbuzzDesign.enums.ExtraType;
import org.example.CricbuzzDesign.enums.MatchStatus;

import java.util.List;

public class LiveState implements MatchState {

    @Override
    public void processBall(Match match, Ball ball) {
        Innings currentInnings = match.getOngoingInnings();

        if (ball.isWicket()) {
            currentInnings.incrementWickets();
            currentInnings.getPlayerStats().get(ball.getBowledBy()).updateWickets(1);
            currentInnings.getPlayerStats().get(ball.getPlayedBy()).updateBallsPlayed(1);
        }
        else if (ball.getExtraType() != null) {
            currentInnings.updateExtras(ball.getRunsScored());
            currentInnings.updateScore(ball.getRunsScored());
            currentInnings.getPlayerStats().get(ball.getPlayedBy()).updateBallsPlayed(1);
        }
        else {
            currentInnings.updateScore(ball.getRunsScored());
            currentInnings.getPlayerStats().get(ball.getPlayedBy()).updateRuns(ball.getRunsScored());
            currentInnings.getPlayerStats().get(ball.getPlayedBy()).updateBallsPlayed(1);
        }

        currentInnings.addBall(ball);
        match.notifyObservers(ball);
        checkForMatchEnd(match);
    }

    public void checkForMatchEnd(Match match) {
        boolean isFinalInnings = match.getMatchStrategy().getInnings() == match.getInnings().size();
        boolean isInningsOver = isInningsOver(match);

        if (isInningsOver) {
            if (isFinalInnings) {
                declareWinner(match);
                match.setCurrentState(MatchStatus.END_STATE);
                match.setMatchState(new EndState());
            }
            else {
                match.setCurrentState(MatchStatus.INBREAK_STATE);
                match.setMatchState(new InBreakState());
            }
        }
    }

    public boolean isInningsOver(Match match) {
        Innings currentInnings = match.getOngoingInnings();

        if (currentInnings.getOvers() >= match.getMatchStrategy().getOvers()) return true;
        else return currentInnings.getWickets() >= currentInnings.getBattingTeam().getPlayers().size() - 1;
    }

    public void declareWinner(Match match) {
        if (match.getMatchStrategy().getInnings() == 2) {
            List<Innings> innings = match.getInnings();

            if (innings.get(0).getScore() > innings.get(1).getScore()) {
                int runs = innings.get(0).getScore() - innings.get(1).getScore() - 1;
                match.setResultMessage(innings.get(0).getBattingTeam().getName() + " won by " + runs + " runs.");
            }
            else if (innings.get(0).getScore() < innings.get(1).getScore()) {
                // TeamB is winner.
                int wickets = innings.get(1).getBattingTeam().getPlayers().size() - 1;
                match.setResultMessage(innings.get(1).getBattingTeam().getName()+ " won by " + wickets + " wickets");
            }
            else {
                match.setResultMessage("Match Tied.");
            }
        }
    }
}
