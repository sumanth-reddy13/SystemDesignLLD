package org.example.CricbuzzDesign.Entity;

import org.example.CricbuzzDesign.enums.Country;
import org.example.CricbuzzDesign.enums.PlayerRole;

public class Player {
    private final int id;
    private String name;
    private Country country;
    private PlayerRole role;

    private Player(PlayerBuilder playerBuilder) {
        this.id = playerBuilder.id;
        this.name = playerBuilder.name;
        this.country = playerBuilder.country;
        this.role = playerBuilder.role;
    }

    public static class PlayerBuilder {
        private int id;
        private String name;
        private Country country;
        private PlayerRole role;

        public PlayerBuilder playerId(int id) {
            this.id = id;
            return this;
        }

        public PlayerBuilder playerName(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder playerCountry(Country country) {
            this.country = country;
            return this;
        }

        public PlayerBuilder playerRole(PlayerRole role) {
            this.role = role;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }

    public int getId() { return this.id; }
    public String  getPlayerName() { return this.name; }
    public Country getPlayerCountry() { return this.country; }
    public PlayerRole getRole() { return this.role; }
}