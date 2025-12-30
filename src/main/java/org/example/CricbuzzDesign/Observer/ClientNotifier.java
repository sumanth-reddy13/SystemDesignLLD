package org.example.CricbuzzDesign.Observer;

import org.example.CricbuzzDesign.Entity.Ball;
import org.example.CricbuzzDesign.Entity.Match;

public class ClientNotifier implements MatchObserver {

    @Override
    public void update(Match match, Ball ball) {
        // TODO Add more details.
        System.out.println("******** Client Notifier ********");
        System.out.println("Notified the client the updated score.");
    }
}
