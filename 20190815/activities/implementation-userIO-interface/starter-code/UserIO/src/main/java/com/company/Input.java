package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class Input implements UserIO {

    Scanner scanner = new Scanner(System.in);




    public int readInt(String prompt) {

        System.out.println("Enter an integer: ");
        String userAnswer = scanner.nextLine();
        int userInt = Integer.parseInt(userAnswer);
        return userInt;
    }


    public long readLong(String prompt) {

        System.out.println("Enter an long: ");
        String longAnswer = scanner.nextLine();
        long userLong = Long.parseLong(longAnswer);
        return userLong;
    }


    public double readDouble(String prompt) {

        System.out.println("Enter an double: ");
        String doubleAnswer = scanner.nextLine();
        double userDouble = Double.parseDouble(doubleAnswer);
        return userDouble;
    }


    public float readFloat(String prompt) {

        System.out.println("Enter an float: ");
        String floatAnswer = scanner.nextLine();
        float userFloat = Float.parseFloat(floatAnswer);
        return userFloat;
    }


    public String readString(String prompt) {

        System.out.println("Enter an string: ");
        String userString = scanner.nextLine();
        return userString;
    }
}
