package edu.wctc;

import edu.wctc.interfaces.Interactable;

public class GardenRoom extends Room implements Interactable {
    public GardenRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "You find yourself in a quiet garden with magical flowers.";
    }

    @Override
    public String interact(Player player) {
        player.addToScore(20);
        return "You smell a magical flower. +20 score!";
    }
}
