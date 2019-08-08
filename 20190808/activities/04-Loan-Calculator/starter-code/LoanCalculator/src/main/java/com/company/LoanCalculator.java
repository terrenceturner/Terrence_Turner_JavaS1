package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        int monthInYear = 12;
        int percent = 100;
//
        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter mortgage: ");
//        int mortgage = scanner.nextInt();
//
//        System.out.println("Enter term of mortgage:");
//        int termOfMortgage = scanner.nextInt();
//
//        System.out.println("Enter annual interest rate of mortgage.");
//        float annualInterest = scanner.nextFloat();
//        float monthlyInterest = annualInterest / percent / monthInYear;
//
//        double mortgagePayment = (mortgage * monthlyInterest) / (1 - Math.pow(1 + monthlyInterest, - monthInYear));
//        mortgagePayment = (double)Math.round(monthlyInterest * 100) / 100;
//
//        System.out.println(mortgagePayment);


        System.out.println("Enter mortgage: ");
        int mortgage = scanner.nextInt();

        System.out.println("Enter term of mortgage:");
        int termOfMortgage = scanner.nextInt();
        int monthlyTerm = termOfMortgage / monthInYear;

        System.out.println("Enter annual interest rate of mortgage.");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / percent / monthInYear;



        double monthlyPayment = (mortgage * monthlyInterest) / (1-Math.pow(1 + monthlyInterest, - monthlyTerm));





        System.out.printf("%6.2f", monthlyPayment);


    }
}
