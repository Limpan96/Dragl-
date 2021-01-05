package com.company;

public class Potion extends Item {
    private int health;
    
    public Potion (String name, String description, int health){
        super(name, description);
        this.health = health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
}
