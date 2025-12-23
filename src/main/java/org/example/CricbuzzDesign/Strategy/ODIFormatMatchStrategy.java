package org.example.CricbuzzDesign.Strategy;

public class ODIFormatMatchStrategy implements MatchFormatStrategy {

    @Override
    public int getInnings() {
        return 2;
    }

    @Override
    public int getOvers() {
        return 50;
    }
}