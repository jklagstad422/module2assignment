package edu.wctc;

import edu.wctc.interfaces.Exitable;

public class ExitRoom extends Room implements Exitable {
    public ExitRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "This room has a glowing portal. Could this be the exit?";
    }

    @Override
    public String exit(Player player) {
        player.addToScore(50);
        return "You found the exit! +50 score!";
    }
}
