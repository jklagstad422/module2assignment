package edu.wctc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Maze Game!");

        // Choose player type
        System.out.print("Choose player type (normal/swift/cheating): ");
        String type = scanner.nextLine().toLowerCase();
        Player player;

        switch(type) {
            case "swift": player = new SwiftPlayer(); break;
            case "cheating": player = new CheatingPlayer(); break;
            default: player = new Player(); break;
        }

        Maze maze = new Maze(player);
        int roomsVisited = 1; // Start in the first room

        while (!maze.isFinished()) {
            System.out.println("\n" + maze.getCurrentRoomDescription());
            System.out.println(maze.getCurrentRoomExits());
            System.out.println("Rooms visited so far: " + roomsVisited);

            // Main command menu
            System.out.println("Enter a command:");
            System.out.println("  m - Move to another room");
            System.out.println("  i - Interact with current room");
            System.out.println("  l - Loot the current room");
            System.out.println("  v - View your inventory");
            System.out.print("Command: ");

            char command = scanner.next().toLowerCase().charAt(0);

            switch (command) {
                case 'm': // Move submenu
                    System.out.println("Choose a direction to move:");
                    System.out.println("  n - North");
                    System.out.println("  s - South");
                    System.out.println("  e - East");
                    System.out.println("  w - West");
                    System.out.println("  u - Up");
                    System.out.println("  d - Down");
                    System.out.print("Direction: ");
                    char direction = scanner.next().toLowerCase().charAt(0);

                    if (maze.move(direction)) {
                        roomsVisited++;
                    } else {
                        System.out.println("You can't go that way.");
                    }
                    break;

                case 'i':
                    System.out.println(maze.interactWithCurrentRoom());
                    break;

                case 'l':
                    System.out.println(maze.lootCurrentRoom());
                    break;

                case 'v':
                    System.out.println(maze.getPlayerInventory());
                    break;

                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }

        System.out.println("Maze Game Over!");
        System.out.println("Final Score: " + maze.getPlayerScore());
        System.out.println("Total Rooms Visited: " + roomsVisited);
        scanner.close();
    }
}
