package com.company;

import java.util.Scanner;

public class DoubleAndAddFive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number1 = Integer.parseInt(scanner.nextLine());

        System.out.println((number1 * 2) + 5);



    }
}
