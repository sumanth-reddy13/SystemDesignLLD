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
    private Team teamA;
    private Team teamB;
    private List<Innings> innings;
    private MatchFormatStrategy matchStrategy;
    private MatchStatus currentState;
    private MatchState matchState;
    private List<MatchObserver> matchObservers;
    private Team tossWonBy;
    private String tossChoice;
    private String resultMessage;

    public Match(Team teamA, Team teamB, MatchFormatStrategy matchFormatStrategy) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.matchStrategy = matchFormatStrategy;
        this.currentState = MatchStatus.SCHEDULED_STATE;
        this.matchState = new ScheduledState();
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
}
