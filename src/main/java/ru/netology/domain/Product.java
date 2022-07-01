package ru.netology.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Product {
    protected int id;
    protected String name;
    protected int cost;


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}


