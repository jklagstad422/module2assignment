package edu.wctc;

public abstract class Room {
    private String name;
    private Room north, south, east, west, up, down;

    public Room(String name) {
        this.name = name;
    }

    public abstract String getDescription();

    public Room getAdjoiningRoom(char direction) {
        switch (direction) {
            case 'n': return north;
            case 's': return south;
            case 'e': return east;
            case 'w': return west;
            case 'u': return up;
            case 'd': return down;
            default: return null;
        }
    }

    public String getExits() {
        StringBuilder exits = new StringBuilder("Exits: ");
        if (north != null) exits.append("n ");
        if (south != null) exits.append("s ");
        if (east != null) exits.append("e ");
        if (west != null) exits.append("w ");
        if (up != null) exits.append("u ");
        if (down != null) exits.append("d ");
        return exits.toString().trim();
    }

    public String getName() {
        return name;
    }

    public boolean isValidDirection(char direction) {
        return getAdjoiningRoom(direction) != null;
    }

    public void setNorth(Room r) { north = r; }
    public void setSouth(Room r) { south = r; }
    public void setEast(Room r) { east = r; }
    public void setWest(Room r) { west = r; }
    public void setUp(Room r) { up = r; }
    public void setDown(Room r) { down = r; }
}

