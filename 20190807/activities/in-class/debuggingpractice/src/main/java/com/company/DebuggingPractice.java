package com.company;

public class DebuggingPractice {

    public static void main(String[] args) {
//        int a = 1;
//        int b = 45;
//        int c = 352;
//        int sum = 0;
//        int avg = (a + b + c) / 3;
//        String message = "This is a test message!";
//        String message2 = "This is a second message!!!";
//
//        System.out.println("Value of a is: " + a);
//        System.out.println("Value of b is " + b);
//        System.out.println("Value of c is: " + c);
//        System.out.println("Average of a,b,c is: " + avg );
//
//        sum = a + b + c;
//
//        System.out.println("Sum = " + sum);

        int age = 18;

        if (age >= 18){
            System.out.println("You are eligible to vote");
        }

        if (age >= 18){
            System.out.println("You are eligible to vote");
        } else {
            System.out.println("Too soon");
        }

        if (age>= 18){
            System.out.println("You are eligible to vote");
        } else if (age == 17){
            System.out.println("Next Year");
        } else {
            System.out.println("Too soon");
        }



        switch (age){
            case 17:
                System.out.println("Next Year");
                break;
            case 18:
                System.out.println("You are eligible to vote");
                break;

        }
    }



}
