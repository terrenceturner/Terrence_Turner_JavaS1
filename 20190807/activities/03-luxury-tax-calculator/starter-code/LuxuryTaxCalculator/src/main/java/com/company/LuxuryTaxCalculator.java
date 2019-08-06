package com.company;

import java.util.Scanner;

public class LuxuryTaxCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter player salary (without the dollar sign or commas): ");
        long player1Salary = Long.parseLong(scanner.nextLine());

        System.out.println("Enter player salary (without the dollar sign or commas): ");
        long player2Salary = Long.parseLong(scanner.nextLine());

        System.out.println("Enter player salary (without the dollar sign or commas): ");
        long player3Salary = Long.parseLong(scanner.nextLine());

        long totalSalaries = player1Salary + player2Salary + player3Salary;
        System.out.println(totalSalaries);

        if (totalSalaries > 40_000_000L){
            System.out.println((totalSalaries - 40_000_000L) * .18);
        }

    }
}
