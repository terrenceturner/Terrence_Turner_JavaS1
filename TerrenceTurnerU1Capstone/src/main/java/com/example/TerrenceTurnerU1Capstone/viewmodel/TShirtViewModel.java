package com.example.TerrenceTurnerU1Capstone.viewmodel;

import java.math.BigDecimal;
import java.util.Objects;

public class TShirtViewModel {

    //Properties
    private int t_shirt_id;
    private String size;
    private String color;
    private String description;
    private BigDecimal price;
    private int quantity;

    //Getters and Setters
    public int getT_shirt_id() {
        return t_shirt_id;
    }

    public void setT_shirt_id(int t_shirt_id) {
        this.t_shirt_id = t_shirt_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    //Equals and HashCodes
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TShirtViewModel that = (TShirtViewModel) o;
        return t_shirt_id == that.t_shirt_id &&
                quantity == that.quantity &&
                size.equals(that.size) &&
                color.equals(that.color) &&
                description.equals(that.description) &&
                price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t_shirt_id, size, color, description, price, quantity);
    }
}
