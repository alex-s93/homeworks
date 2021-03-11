package com.alevel.homework23.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order {
    private long id;
    private Product product;
    private User user;
    private int count;
    private Status status;
    private LocalDateTime orderDate;

    public Order(long id, Product product, User user, int count, Status status, LocalDateTime orderDate) {
        this.id = id;
        this.product = product;
        this.user = user;
        this.count = count;
        this.status = status;
        this.orderDate = orderDate;
    }

    public Order() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "product=" + product +
                ", user=" + user +
                ", count=" + count +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }
}
