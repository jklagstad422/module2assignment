package edu.wctc;

import edu.wctc.interfaces.Lootable;

public class TreasureRoom extends Room implements Lootable {
    public TreasureRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "You see a glittering treasure chest in the room.";
    }

    @Override
    public String loot(Player player) {
        player.addToInventory("Gold Coin");
        player.addToScore(10);
        return "You looted a Gold Coin! +10 score.";
    }
}