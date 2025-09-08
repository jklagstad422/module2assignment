package edu.wctc;
import edu.wctc.interfaces.Interactable;

import java.util.Scanner;

public class LibraryRoom extends Room implements Interactable {
    public LibraryRoom(String name) { super(name); }

    @Override
    public String getDescription() {
        return "You are surrounded by dusty old bookshelves. Some books look ancient.";
    }

    @Override
    public String interact(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getInteractionOptions());
        String choice = scanner.nextLine();

        switch(choice) {
            case "1":
                player.addToScore(5);
                return "You read an ancient scroll. +5 score!";
            case "2":
                return "You examine the bookshelves but find nothing of value.";
            default:
                return "You hesitate and do nothing.";
        }
    }

    @Override
    public String getInteractionOptions() {
        return "Options:\n1 - Read a scroll (+5 score)\n2 - Examine bookshelves\nChoose an action by number:";
    }
}