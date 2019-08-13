package com.company;

public class App {

    public static void main(String[] args) {

        Student joe = new Student();
        joe.setName("Joe");
        joe.getGpa(3.2);

        Student billy = new Student();
        billy.setName("Billy");
        billy.getGpa(4.0);

        joe.greet();
        billy.greet();

    }

}
