package org.example.CricbuzzDesign.Strategy;

public class T20MatchFormatStrategy implements MatchFormatStrategy {

    @Override
    public int getInnings() {
        return 2;
    }

    @Override
    public int getOvers() {
        return 20;
    }
}
