package com.company;

public class Module4 {


    // Methods
    public static int sumInts (int num1, int num2){
        return num1 + num2;
    }

    public static int multInts (int num1, int num2){
        return num1 * num2;
    }


    public static void sayHi(){
        System.out.println("Hi!!!");
    }



    public static void main(String[] args) {


        // Calling methods
        int sum = sumInts(3, 4);
        System.out.println(sum);


        int product = multInts(2, 19);
        System.out.println(product);


        sayHi();




    }









}
