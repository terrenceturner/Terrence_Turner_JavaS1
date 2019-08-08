package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your age?");
        int age = Integer.parseInt(scanner.nextLine());


        if (age > 100){
            System.out.println("century");
            System.out.println("octogenarian");
            System.out.println("retire");
            System.out.println("aarp");
            System.out.println("president");
            System.out.println("alcohol");
            System.out.println("vote");
        } else if (age > 80 && age < 89){
            System.out.println("octogenarian");
            System.out.println("retire");
            System.out.println("aarp");
            System.out.println("president");
            System.out.println("alcohol");
            System.out.println("vote");
        } else if (age > 65){
            System.out.println("retire");
            System.out.println("aarp");
            System.out.println("president");
            System.out.println("alcohol");
            System.out.println("vote");
        } else if (age > 55){
            System.out.println("aarp");
            System.out.println("president");
            System.out.println("alcohol");
            System.out.println("vote");
        } else if (age > 35){
            System.out.println("president");
            System.out.println("alcohol");
            System.out.println("vote");
        } else if (age > 21) {
            System.out.println("alcohol");
            System.out.println("vote");
        } else if (age > 18) {
            System.out.println("vote");
        } else {
//            System.out.println("You too young");
        }

////
//        if (age > 18){
//            System.out.println("Vote");
//        } else if (age > 21){
//            System.out.println("Drink alchohol");
//        } else if (age > 35){
//            System.out.println("Be president");
//        } else if (age > 55){
//            System.out.println("Is eligible for AARP");
//        } else if (age > 65){
//            System.out.println("Can retire");
//        } else if (age > 80 && age < 89){
//            System.out.println("Is an octogenerian");
//        } else if (age > 100){
//            System.out.println("Is more than a century old");
//        } else {
//            System.out.println("You too young");
//        }

    }
}
