package com.alevel.homework23.entities;

public class Product {
    private long id;
    private String name;
    private Category category;
    private double price;

    public Product(long id, String name, Category category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Product() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product:" +
                " {id=" + id +
                ", name='" + name + "'" +
                ", " + category +
                ", price=" + price + "}";
    }
}
