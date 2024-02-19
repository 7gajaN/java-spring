package com.unibuc.Spring.Project.model;

import jakarta.persistence.Entity;

@Entity
public class Cart extends Order{
    public Cart (User user){
        super(user);
    }
}
