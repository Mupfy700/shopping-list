package com.danielhahn.shoppinglistapi;

import javax.persistence.Entity; // Import the Entity class
import javax.persistence.Id;

@Entity
public class Todo {
    @Id
    private String ItemName;

    // Getters and Setters
    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }
}
