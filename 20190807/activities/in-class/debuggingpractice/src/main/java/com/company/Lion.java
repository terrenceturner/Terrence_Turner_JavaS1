package com.company;

import java.util.Scanner;

public class Lion {


    private String name;
    private int age;
    private int weight;

    //getters and setters
    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    //constructor
    public Lion(String nameIn, int ageIn, int weighIn){
        this.name = nameIn;
        this.age = ageIn;
        this.weight = weighIn;
    }


    //method
    public void roar(){
        System.out.println("ROAR!!!");
    }

    public void pounce(){
        System.out.println("POUNCING");
    }

    public void nap(){
        System.out.println("ZZZzzzZZzz");
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Lion bigCat = new Lion("Simba", 34, 200);
            String bigCatName = bigCat.getName();
            bigCat.nap();
            bigCat.roar();
            bigCat.pounce();


    }



}
