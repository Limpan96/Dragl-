package com.company;

public class Item {
    private String name;
    private String description;
    
//Konstruktor för att skapa ett nytt item
    public Item(String name, String description) {
        this.name = name;
       this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

