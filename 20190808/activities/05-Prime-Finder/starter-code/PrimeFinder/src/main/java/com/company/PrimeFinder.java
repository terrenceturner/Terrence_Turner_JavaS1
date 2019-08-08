package com.company;

import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");

        int userNumber = Integer.parseInt(scanner.nextLine());

        for (int number = 2; number <= userNumber; number++){

            boolean primeNumber = true;
            for (int i=2; i <= number/2; i++){
                if (number % i == 0){
                    primeNumber = false;
                    break;
                }
            }

            if (primeNumber)
                System.out.println(number);
        }

    }
}
