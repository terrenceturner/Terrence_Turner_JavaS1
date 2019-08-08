package com.company;

import java.util.Scanner;



public class RectPavingCompany {



//    public static int promptDimension(String msg){
//        Scanner scan = new Scanner(System.in);
//
//        System.out.format("What is the %s of the driveway in  feet" , msg );
//
//        return Integer.parseInt(scan.nextLine()) ;
//    }
//
//    public static void outputDimensions(String name , int value){
//        System.out.format("The %s of the driveway is %d square feet.%n" , name , value);
//    }
//
//
//    public static void outputCosts(String name , float value) {
//        System.out.format("The cost of the %s is %f . %n" , name , value );
//    }

    public static void main(String[] args) {

        int length = promptDimension("length");
        int width = promptDimension("Width");
        float cementCost = 12.5f;
        float framingCost = 8.25f;

        int area = length * width;
        int perimeter = 2 * length + 2 * width;

        outputDimensions("area", area);
        outputDimensions("perimeter", perimeter);

        outputCosts("Cement", area * cementCost);
        outputCosts("framing/footers", perimeter * framingCost);
    }

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
