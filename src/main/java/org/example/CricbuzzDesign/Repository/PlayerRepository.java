package org.example.CricbuzzDesign.Repository;

import org.example.CricbuzzDesign.Entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PlayerRepository {
    Map<Integer, Player> players = new HashMap<>();

    public void save(Player player) {
        players.put(player.getId(), player);
    }

    public Optional<Player> getPlayerById(int id) {
        return Optional.ofNullable(players.get(id));  // ofNullable returns empty if there is no object.
    }
}