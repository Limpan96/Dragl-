package com.company;

public class Weapon extends Item {
    
    int damage;

    public Weapon(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }

    public void setDamage(int damage) { // behövs eller inte?
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}

