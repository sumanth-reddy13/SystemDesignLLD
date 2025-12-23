package org.example.CricbuzzDesign.Entity;

import org.example.CricbuzzDesign.enums.WicketType;

public class Wicket {
    private final WicketType wicketType;
    private final Player playerOut;
    private final Player caughtBy;
    private final Player runOutBy;
    private final Player stumpBy;

    private Wicket(WicketBuilder wicketBuilder) {
        this.wicketType = wicketBuilder.wicketType;
        this.playerOut = wicketBuilder.playerOut;
        this.caughtBy = wicketBuilder.caughtBy;
        this.runOutBy = wicketBuilder.runOutBy;
        this.stumpBy = wicketBuilder.stumpBy;
    }

    public static class WicketBuilder {
        private WicketType wicketType;
        private Player playerOut;
        private Player caughtBy;
        private Player runOutBy;
        private Player stumpBy;

        public WicketBuilder playerOut(Player player) {
            this.playerOut = player;
            return this;
        }

        public WicketBuilder wicketType(WicketType wicketType) {
            this.wicketType = wicketType;
            return this;
        }

        public WicketBuilder caughtBy(Player player) {
            this.caughtBy = player;
            return this;
        }
        public WicketBuilder runOutBy(Player player) {
            this.runOutBy = player;
            return this;
        }
        public WicketBuilder stumpBy(Player player) {
            this.stumpBy = player;
            return this;
        }
        public Wicket build() {
            return new Wicket(this);
        }
    }

    public Player getPlayedBy() { return this.playerOut; }
    public WicketType getWicketType() { return this.wicketType; }
    public Player getCaughtBy() { return this.caughtBy; }
    public Player getRunOutBy() { return this.runOutBy; }
    public Player getStumpBy() { return this.stumpBy; }
}