package edu.wctc;
import edu.wctc.interfaces.*;

public class Maze {
    private Room currentRoom;
    private Player player;
    private boolean isFinished;

    public Maze(Player player) {
        this.player = player;
        this.isFinished = false;

        TreasureRoom treasure = new TreasureRoom("Treasure Room");
        LibraryRoom library = new LibraryRoom("Library");
        ArmoryRoom armory = new ArmoryRoom("Armory");
        GardenRoom garden = new GardenRoom("Garden");
        ExitRoom exit = new ExitRoom("Exit Room");

        treasure.setEast(library);
        library.setWest(treasure);
        library.setEast(armory);
        armory.setWest(library);
        armory.setNorth(garden);
        garden.setSouth(armory);
        garden.setEast(exit);
        exit.setWest(garden);

        currentRoom = treasure;

        if (player instanceof Cheating) {
            lootAllRooms();
        }
    }

    private void lootAllRooms() {
        Room[] rooms = {currentRoom, currentRoom.getAdjoiningRoom('e'), currentRoom.getAdjoiningRoom('e') != null ? currentRoom.getAdjoiningRoom('e').getAdjoiningRoom('e') : null};
        for (Room room : rooms) {
            if (room instanceof Lootable) {
                ((Lootable) room).loot(player);
            }
        }
        System.out.println("CheatingPlayer automatically looted available rooms!");
    }

    public String exitCurrentRoom() {
        if (currentRoom instanceof Exitable) {
            isFinished = true;
            return ((Exitable) currentRoom).exit(player);
        }
        return "This room cannot be exited.";
    }

    public String interactWithCurrentRoom() {
        if (currentRoom instanceof Interactable) {
            Interactable room = (Interactable) currentRoom;
            String result = room.interact(player);

            if (player instanceof Swift) {
                ((Swift) player).useSwiftAbility();
            }

            return result;
        }
        return "Nothing to interact with here.";
    }

    public String lootCurrentRoom() {
        if (currentRoom instanceof Lootable) {
            String result = ((Lootable) currentRoom).loot(player);
            if (player instanceof Swift) {
                ((Swift) player).useSwiftAbility();
            }
            return result;
        }
        return "Nothing to loot here.";
    }

    public boolean move(char direction) {
        if (currentRoom.isValidDirection(direction)) {
            currentRoom = currentRoom.getAdjoiningRoom(direction);

            if (player instanceof Swift) {
                ((Swift) player).useSwiftAbility();
            }

            if (player instanceof Cheating && currentRoom instanceof Lootable) {
                ((Lootable) currentRoom).loot(player);
            }

            return true;
        }
        return false;
    }

    public int getPlayerScore() { return player.getScore(); }
    public String getPlayerInventory() { return player.getInventory(); }
    public String getCurrentRoomDescription() { return currentRoom.getDescription(); }
    public String getCurrentRoomExits() { return currentRoom.getExits(); }
    public boolean isFinished() { return isFinished; }
}
