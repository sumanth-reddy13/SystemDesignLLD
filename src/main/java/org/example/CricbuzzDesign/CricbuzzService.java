package org.example.CricbuzzDesign;

import org.example.CricbuzzDesign.Entity.Match;
import org.example.CricbuzzDesign.Entity.Player;
import org.example.CricbuzzDesign.Entity.Team;
import org.example.CricbuzzDesign.Repository.MatchRepository;
import org.example.CricbuzzDesign.Repository.PlayerRepository;
import org.example.CricbuzzDesign.Strategy.MatchFormatStrategy;

public class CricbuzzService {
    private static CricbuzzService instance;
    private final MatchRepository matchRepository = new MatchRepository();
    private final PlayerRepository playerRepository = new PlayerRepository();

    public static synchronized CricbuzzService getInstance() {
        if (instance == null) {
            instance = new CricbuzzService();
        }
        return instance;
    }

    public Match createMatch(Team teamA, Team teamB, MatchFormatStrategy matchFormatStrategy) {
        Match match = new Match(teamA, teamB, matchFormatStrategy);
        matchRepository.save(match);
        return match;
    }

    public Player createPlayer(Player player) {
        playerRepository.save(player);
        return player;
    }

    public void startMatch(Match match) {
        match.startNextInnings(match);
    }

    public void endMatch(Match match) {
        /**
         *  change currentState to EndState
         *  change MatchState to EndState.
         */
        // TODO update result
    }


}
