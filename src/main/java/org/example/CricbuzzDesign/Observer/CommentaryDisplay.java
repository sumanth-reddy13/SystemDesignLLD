package org.example.CricbuzzDesign.Observer;

import org.example.CricbuzzDesign.Entity.Ball;
import org.example.CricbuzzDesign.Entity.Match;

public class CommentaryDisplay implements MatchObserver {

    @Override
    public void update(Match match, Ball ball) {
        System.out.println("BALL " + ball.getBallNumber());
        if (ball.isWicket()) {
            System.out.println("***** WICKET *****");
        }
        else {
            System.out.println("RUNS SCORED: " + ball.getRunsScored());
        }

        System.out.println("PLAYED BY : " + ball.getPlayedBy());
        System.out.println("BOWLED BY : " + ball.getBowledBy());
        System.out.println("******** COMMENTARY ********");
        System.out.println(ball.getCommentary());
    }
}
