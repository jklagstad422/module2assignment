package edu.wctc;
import edu.wctc.interfaces.Cheating;

public class CheatingPlayer extends Player implements Cheating {
    @Override
    public void useCheat() {
        System.out.println("Cheating activated! You automatically loot all rooms.");
    }
}
