package com.company;

import java.util.Scanner;

public class RightTriangleChecker {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int side1 = 0;
        int side2 = 0;
        int side3 = 0;

        System.out.println("Enter three integers:");
        System.out.println("Side 1: ");
        String side1String = scanner.nextLine();
        side1 = Integer.parseInt(side1String);


        do {
            System.out.println("Side 2: ");
            String side2String = scanner.nextLine();
            side2 = Integer.parseInt(side2String);


            if (side2 < side1){
                System.out.println(side2 + " is smaller than " + side1 + ". Try again.");
            }

        } while (side2 < side1);



        do {
            System.out.println("Side 3: ");
            String side3String = scanner.nextLine();
            side3 = Integer.parseInt(side3String);

            if (side3 < side2){
                System.out.println(side3 + " is smaller than " + side2 + ". Try again.");

            }

        } while (side3 < side2);




        System.out.println("Your three sides are " + side1 + " " + side2 + " " + side3);

        if ((side1 == side2) || (side1 == side3) || (side2 == side3)){
            System.out.println("NO! These sides do not make a right triangle!");
        } else {
            System.out.println("These sides do make a right triangle. Yippy-skippy!");
        }




    }


}
