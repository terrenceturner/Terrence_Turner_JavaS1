package com.company;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int userNumber = Integer.parseInt(scanner.nextLine());

        if (userNumber % 2 == 0){
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }




    }
}
