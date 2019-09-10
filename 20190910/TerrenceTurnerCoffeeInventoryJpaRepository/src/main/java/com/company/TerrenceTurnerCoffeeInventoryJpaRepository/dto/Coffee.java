package com.company.TerrenceTurnerCoffeeInventoryJpaRepository.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "coffee")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer coffee_id;
    private Integer roaster_id;
    private String name;
    private Integer count;
    private Double unit_price;
    private String description;
    private String type;

    public Integer getCoffee_id() {
        return coffee_id;
    }

    public void setCoffee_id(Integer coffee_id) {
        this.coffee_id = coffee_id;
    }

    public Integer getRoaster_id() {
        return roaster_id;
    }

    public void setRoaster_id(Integer roaster_id) {
        this.roaster_id = roaster_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return coffee_id.equals(coffee.coffee_id) &&
                roaster_id.equals(coffee.roaster_id) &&
                name.equals(coffee.name) &&
                count.equals(coffee.count) &&
                unit_price.equals(coffee.unit_price) &&
                description.equals(coffee.description) &&
                type.equals(coffee.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffee_id, roaster_id, name, count, unit_price, description, type);
    }
}
