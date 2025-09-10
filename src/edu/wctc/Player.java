package edu.wctc;

import java.util.ArrayList;

public class Player {
    private int score;
    private ArrayList<String> inventory;

    public Player() {
        score = 0;
        inventory = new ArrayList<>();
    }

    public void addToInventory(String item) {
        inventory.add(item);
    }

    public void addToScore(int points) {
        score += points;
    }

    public String getInventory() {
        if (inventory.isEmpty()) {
            return "Your inventory is empty.";
        }
        return "Inventory: " + String.join(", ", inventory);
    }

    public int getScore() {
        return score;
    }
}
