package com.company;

import java.util.Scanner;

public class UltimateQuestion {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int userNumber;

        do {
            System.out.println("Pick a number between 1 and 100.");
            userNumber = Integer.parseInt(scanner.nextLine());

        } while (userNumber != 42);

        System.out.println("That's the number I was looking for! 42 is definitely the answer!");

    }
}
