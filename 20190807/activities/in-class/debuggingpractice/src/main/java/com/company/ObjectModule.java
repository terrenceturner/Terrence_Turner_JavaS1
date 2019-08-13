package com.company;

public class ObjectModule {

    public static void main(String[] args) {

        //New object
        Person jim = new Person();
        jim.setName("Jim");

        Person callie = new Person();
        callie.setName("Callie");​

        //Calling sayHello method
        jim.sayHello();
        callie.sayHello();

    }


}
