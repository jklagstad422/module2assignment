package edu.wctc.interfaces;
import edu.wctc.Player;

public interface Interactable {
    String interact(Player player);

    default String getInteractionOptions() {
        return "There is nothing special to interact with.";
    }
}