package org.example.CricbuzzDesign.Repository;

import org.example.CricbuzzDesign.Entity.Match;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MatchRepository {
    Map<String, Match> matches = new HashMap<>();

    public void save(Match match) {
        matches.put(match.getId(), match);
    }

    public Optional<Match> getMatchById(String id) {
        return Optional.ofNullable(matches.get(id));  // ofNullable returns empty if there is no object.
    }
}
