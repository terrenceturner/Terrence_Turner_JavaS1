package com.company.interfaceapproach.concreteapproach;

public class Shape {


    private String name;
    private String color;
    private int xCoordinate;
    private int yCoordinate;


    public void area(){

    }

    public void perimeter(){

    }


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



    //constructor
    public Shape(String name, String color, int xCoordinate, int yCoordinate){
        this.name = name;
        this.color = color;
        this.xCoordinate = yCoordinate;
        this.yCoordinate = yCoordinate;
    }


}
