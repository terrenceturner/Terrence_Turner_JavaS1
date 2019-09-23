package com.example.TerrenceTurnerU1Capstone.viewmodel;

import java.math.BigDecimal;
import java.util.Objects;

public class GameViewModel {

    //Properties
    private int game_id;
    private String title;
    private String esrb_rating;
    private String description;
    private BigDecimal price;
    private String studio;
    private int quantity;

    //Getters and Setters
    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrb_rating() {
        return esrb_rating;
    }

    public void setEsrb_rating(String esrb_rating) {
        this.esrb_rating = esrb_rating;
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

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
        GameViewModel that = (GameViewModel) o;
        return game_id == that.game_id &&
                quantity == that.quantity &&
                title.equals(that.title) &&
                esrb_rating.equals(that.esrb_rating) &&
                description.equals(that.description) &&
                price.equals(that.price) &&
                studio.equals(that.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game_id, title, esrb_rating, description, price, studio, quantity);
    }
}
