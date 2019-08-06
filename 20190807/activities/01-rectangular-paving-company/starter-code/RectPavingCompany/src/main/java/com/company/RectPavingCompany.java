package com.company;

import java.util.Scanner;



public class RectPavingCompany {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter width of driveway: " + "ft");
        int width = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter length of driveway: " + "ft");
        int length = Integer.parseInt(scanner.nextLine());

        int area = length * width;
        int perimeter = length + length + width + width;

        System.out.println("Area is: " + area);
        System.out.println("Perimeter is: " + perimeter);

        double cement = 12.50;
        double framing = 8.25;

        double subtotalCement = cement * area;
        double subtotalFraming = framing * perimeter;

        System.out.printf("Total for cement: %.2f \n", subtotalCement);


        System.out.printf("Total framing: %.2f \n",  subtotalFraming);


        System.out.println("What is the cost of the cement? ");
        double cementUser = Double.parseDouble(scanner.nextLine());

        System.out.println("What is the cost of the framing? ");
        double framingUser = Double.parseDouble(scanner.nextLine());



        double cementTotal = cementUser * area;
        double framingTotal = framingUser * perimeter;

        System.out.printf("Total cement: %.2f \n", cementTotal );
        System.out.printf("Total framing: %.2f \n", framingTotal);


    }
}
