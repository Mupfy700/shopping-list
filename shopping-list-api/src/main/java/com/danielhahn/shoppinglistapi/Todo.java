package com.danielhahn.shoppinglistapi;

import javax.persistence.Entity; // Import the Entity class
import javax.persistence.Id;

@Entity
public class Todo {
    @Id
    private String name;

    // Getters and Setters
}
