package edu.wctc;

import edu.wctc.interfaces.Lootable;

public class ArmoryRoom extends Room implements Lootable {
    public ArmoryRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "You enter an old armory filled with rusty weapons.";
    }

    @Override
    public String loot(Player player) {
        player.addToInventory("Sword");
        player.addToScore(15);
        return "You picked up a Sword! +15 score.";
    }
}
