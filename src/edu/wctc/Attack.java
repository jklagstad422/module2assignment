package edu.wctc;

public class Attack {
    private AttackType type;
    private int damage;

    public Attack(AttackType type, int damage) {
        this.type = type;
        this.damage = damage;
    }

    public AttackType getType() { return type; }
    public int getDamage() { return damage; }

    @Override
    public String toString() {
        return type + " attack with " + damage + " damage";
    }
}
