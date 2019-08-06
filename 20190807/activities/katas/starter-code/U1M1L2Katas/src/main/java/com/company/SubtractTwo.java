package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());

        int num2 = Integer.parseInt(scanner.nextLine());

        int substract = num1 - num2;

        System.out.println(substract);


    }
}
