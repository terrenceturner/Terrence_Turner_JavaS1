package com.company;

import java.util.Scanner;


public class ArrayFunUserArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] userArray = new int[5];



        for (int i = 0; i < userArray.length; i++){
            System.out.println("Enter a number: ");
            String userString = scanner.nextLine();
            userArray[i] = Integer.parseInt(userString);
        }

        System.out.println("You entered: ");

        for (int element:userArray) {
            System.out.println(element);
        }


    }
}
