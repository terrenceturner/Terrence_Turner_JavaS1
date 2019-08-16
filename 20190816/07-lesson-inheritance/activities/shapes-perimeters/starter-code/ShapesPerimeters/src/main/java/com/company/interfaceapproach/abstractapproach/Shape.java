package com.company.interfaceapproach.abstractapproach;

public abstract class Shape {

    private String name;
    private String color;
    private int xCoordinate;
    private int yCoordinate;


    public abstract void area();

    public abstract void perimeter();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }


    public Shape(String name, String color, int xCoordinate, int yCoordinate){
        this.name = name;
        this.color = color;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }



}
