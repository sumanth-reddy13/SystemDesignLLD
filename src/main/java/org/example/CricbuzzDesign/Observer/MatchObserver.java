package org.example.CricbuzzDesign.Observer;

import org.example.CricbuzzDesign.Entity.Ball;
import org.example.CricbuzzDesign.Entity.Match;

public interface MatchObserver {
    public void update(Match match, Ball ball);
}
