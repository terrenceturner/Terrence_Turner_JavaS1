package com.company;

import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        float num1 = Float.parseFloat(scanner.nextLine());

        System.out.println("Enter another number: ");
        float num2 = Float.parseFloat(scanner.nextLine());

        System.out.println("Enter one more number: ");
        float num3 = Float.parseFloat(scanner.nextLine());

        float sum = num1 + num2 + num3;
        float average = sum / 3.00f;

        System.out.printf("%.2f \n", average);


    }
}
