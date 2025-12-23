package org.example.CricbuzzDesign.Entity;

import org.example.CricbuzzDesign.CommentaryManager;
import org.example.CricbuzzDesign.enums.ExtraType;

public class Ball {
    private final int ballNumber;
    private final Player playedBy;
    private final Player bowledBy;
    private final int runsScored;
    private final Wicket wicket;
    private final ExtraType extraType;
    private final String commentary;

    private Ball(BallBuilder ballBuilder) {
        this.ballNumber = ballBuilder.ballNumber;
        this.playedBy = ballBuilder.playedBy;
        this.bowledBy = ballBuilder.bowledBy;
        this.runsScored = ballBuilder.runsScored;
        this.wicket = ballBuilder.wicket;
        this.extraType = ballBuilder.extraType;
        this.commentary = ballBuilder.commentary;
    }

    public static class BallBuilder {
        private int ballNumber;
        private Player playedBy;
        private Player bowledBy;
        private int runsScored;
        private Wicket wicket;
        private ExtraType extraType;
        private String commentary;

        public BallBuilder withBallNumber(int ballNumber) {
            this.ballNumber = ballNumber;
            return this;
        }

        public BallBuilder playedBy(Player player) {
            this.playedBy = player;
            return this;
        }

        public BallBuilder withRuns(int runs) {
            this.runsScored = runs;
            return this;
        }

        public BallBuilder withWicket(Wicket wicket) {
            this.wicket = wicket;
            return this;
        }

        public BallBuilder withExtra(ExtraType extraType) {
            this.extraType = extraType;
            return this;
        }

        public Ball build() {
            if (commentary == null) {
                commentary = new CommentaryManager().generateCommentary(new Ball(this));
            }

            return new Ball(this);
        }
    }

    public boolean isWicket() {
        return this.wicket != null;
    }

    public boolean isBoundary() {
        return this.runsScored == 4 || this.runsScored == 6;
    }

    public int getBallNumber() {
        return this.ballNumber;
    }

    public Player getPlayedBy() {
        return this.playedBy;
    }

    public Player getBowledBy() {
        return this.bowledBy;
    }

    public int getRunsScored() {
        return this.runsScored;
    }

    public Wicket getWicket() {
        return this.wicket;
    }

    public ExtraType getExtraType() {
        return this.extraType;
    }

    public String getCommentary() {
        return this.commentary;
    }
}
