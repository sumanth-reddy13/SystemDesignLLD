package org.example.CricbuzzDesign.Entity;

import org.example.CricbuzzDesign.Observer.MatchObserver;
import org.example.CricbuzzDesign.State.MatchState;
import org.example.CricbuzzDesign.State.ScheduledState;
import org.example.CricbuzzDesign.Strategy.MatchFormatStrategy;
import org.example.CricbuzzDesign.enums.MatchStatus;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private String id;
    private final Team teamA;
    private final Team teamB;
    private final List<Innings> innings;
    private final MatchFormatStrategy matchStrategy;
    private MatchStatus currentState;
    private MatchState matchState;
    private List<MatchObserver> matchObservers;
    private final Team tossWonBy;
    private final String tossChoice;
    private String resultMessage;

    // TODO Create a builder class to create Match object.
    public Match(Team teamA, Team teamB, MatchFormatStrategy matchFormatStrategy, Team tossWonBy, String tossChoice) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.matchStrategy = matchFormatStrategy;
        this.currentState = MatchStatus.SCHEDULED_STATE;
        this.matchState = new ScheduledState();
        this.tossChoice = tossChoice;
        this.tossWonBy = tossWonBy;
        this.innings = new ArrayList<>();
    }

    public void addObserver(MatchObserver observer) {
        matchObservers.add(observer);
    }

    public void removeObserver(MatchObserver observer) {
        matchObservers.remove(observer);
    }

    public void notifyObservers(Ball ball) {
        for (MatchObserver observer : matchObservers) {
            observer.update(this, ball);
        }
    }

    public void processBall(Ball ball) {
        Innings currentInning = this.innings.get(innings.size() - 1);
        matchState.processBall(this, ball);
    }

    public void setCurrentState(MatchStatus matchStatus) {
        this.currentState = matchStatus;
    }

    public void setMatchState(MatchState matchState) {
        this.matchState = matchState;
    }

    public void startNextInnings(Match match) {
        matchState.startNextInnings(match);
    }

    public Innings getOngoingInnings() {
        return innings.get(innings.size() - 1);
    }

    public String getId() { return this.id; }

    public MatchFormatStrategy getMatchStrategy() {
        return this.matchStrategy;
    }

    public List<Innings> getInnings() {
        return this.innings;
    }

    public void setResultMessage(String message) {
        this.resultMessage = message;
    }

    public String getResult() { return this.resultMessage; }

    public Team getTeamA() { return this.teamA; }

    public Team getTeamB() { return this.teamB; }

    public Team getTossWonBy() { return this.tossWonBy; }

    public String getTossChoice() { return this.tossChoice; }
}
