package org.example.CricbuzzDesign;

import org.example.CricbuzzDesign.Entity.Ball;
import org.example.CricbuzzDesign.enums.ExtraType;
import org.example.CricbuzzDesign.enums.WicketType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CommentaryManager {
    private final Map<String, List<String>> commentaryTemplates = new HashMap<>();
    private final Random random = new Random();

    public CommentaryManager() {
        initializeTemplates();
    }

    public void initializeTemplates() {
        commentaryTemplates.put("RUNS_0", List.of(
                "Pushed to mid-on. No run",
                "That's a peach. Bowled on a good length. Dragged the batsman forward and moved away slightly after pitching. Very close to the outside edge of the bat",
                "Bowled on the stumps. Defended solidly by the batsman towards the bowler.",
                "A dot ball to end the over."
        ));
        commentaryTemplates.put("RUNS_1", List.of(
                "Guided the ball to third man for a single.",
                "Defended with soft hands. Batsmen steal a single. Good bit of running from the both the batsman.",
                "A push towards long-on and batsman take a single."
        ));
        commentaryTemplates.put("RUNS_2", List.of(
                "Two runs taken!",
                "Quick double taken by %s.",
                "Pushed to mid-on for two."
        ));
        commentaryTemplates.put("RUNS_4", List.of(
                "FOUR! %s smashes it through the covers!",
                "Beautiful shot! That's a boundary.",
                "Finds the gap perfectly. Four runs."
        ));
        commentaryTemplates.put("RUNS_6", List.of(
                "SIX! That's out of the park!",
                "%s sends it sailing over the ropes!",
                "Massive hit! It's a maximum."
        ));

        // Templates for wickets
        commentaryTemplates.put("WICKET_" + WicketType.BOWLED, List.of(
                "BOWLED HIM! %s misses completely and the stumps are shattered!",
                "Cleaned up! A perfect yorker from %s."
        ));
        commentaryTemplates.put("WICKET_" + WicketType.CAUGHT, List.of(
                "CAUGHT! %s skies it and the fielder takes a comfortable catch.",
                "Out! A brilliant catch in the deep by %s."
        ));
        commentaryTemplates.put("WICKET_" + WicketType.LBW, List.of(
                "LBW! That one kept low and struck %s right in front.",
                "%s completely misjudged the line and pays the price."
        ));

        commentaryTemplates.put("WICKET_" + WicketType.STUMPED, List.of(
                "STUMPED! %s misses it, and the keeper does the rest!",
                "Gone! Lightning-fast work by the keeper to stump %s."
        ));

        // Templates for extras
        commentaryTemplates.put("EXTRA_" + ExtraType.WIDE, List.of(
                "That's a wide. The umpire signals an extra run.",
                "Too far down the leg side, that'll be a wide."
        ));
        commentaryTemplates.put("EXTRA_" + ExtraType.NO_BALL, List.of(
                "No ball! %s has overstepped. It's a free hit.",
                "It's a no-ball for overstepping."
        ));
    }

    public String generateCommentary(Ball ball) {
        String key = getEventKey(ball);
        List<String> templates = commentaryTemplates.getOrDefault(key, List.of("Just a Standard delivery."));

        // TODO Should be able to dynamically change player name in the commentary.
        return templates.get(random.nextInt(templates.size()));
    }

    public String getEventKey(Ball ball) {
        if (ball.isWicket()) {
            return ball.getWicket().getWicketType().toString();
        }
        else if (ball.getExtraType() != null) {
            return ball.getExtraType().toString();
        }
        else if (ball.getRunsScored() >= 0 && ball.getRunsScored() <= 6) {
            switch (ball.getRunsScored()) {
                case 0: return "RUNS_0";
                case 1: return "RUNS_1";
                case 2: return "RUNS_2";
                case 3: return "RUNS_3";
                case 4: return "RUNS_4";
                case 6: return "RUNS_6";
            }
        }
        return "DEFAULT";
    }
}
