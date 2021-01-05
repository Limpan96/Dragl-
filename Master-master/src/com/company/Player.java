package com.company;

import java.util.ArrayList;

public class Player {
    private String name;
    private int healthPoints;
    private int damage;
    private ArrayList<String> items = new ArrayList<String>();
    // private Item items = new Item(); // [] = {"sword", "axe", "hammer"};

    //Konstruktor för att skapa en ny spelare
    public Player(String name, int healthPoints, int damage, String item) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.damage = damage;
        items.add(item);
    }

    //Setters och getters
    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return name;
    }

    public void setHealthPoints(int newHP) {
        this.healthPoints = newHP;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

//    public void addDamage(int damage) {
//        this.damage += damage;
//    }

    public int getDamage() {
        return damage;
    }

    public void doDamage(int damageTaken) {
        healthPoints -= damageTaken;
    }
    
    public void addItem(String item) {
        items.add(item);
    }
}