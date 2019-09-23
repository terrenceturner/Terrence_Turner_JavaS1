package com.example.TerrenceTurnerU1Capstone.viewmodel;

import java.math.BigDecimal;
import java.util.Objects;

public class ConsoleViewModel {

    //Properties
    private int console_id;
    private String model;
    private String manufacturer;
    private String memory_amount;
    private String processor;
    private BigDecimal price;
    private int quantity;

    //Getters and Setters
    public int getConsole_id() {
        return console_id;
    }

    public void setConsole_id(int console_id) {
        this.console_id = console_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemory_amount() {
        return memory_amount;
    }

    public void setMemory_amount(String memory_amount) {
        this.memory_amount = memory_amount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
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
        ConsoleViewModel that = (ConsoleViewModel) o;
        return console_id == that.console_id &&
                quantity == that.quantity &&
                model.equals(that.model) &&
                manufacturer.equals(that.manufacturer) &&
                memory_amount.equals(that.memory_amount) &&
                processor.equals(that.processor) &&
                price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(console_id, model, manufacturer, memory_amount, processor, price, quantity);
    }

}
