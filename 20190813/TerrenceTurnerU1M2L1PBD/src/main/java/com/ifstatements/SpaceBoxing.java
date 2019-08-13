package com.ifstatements;


import java.util.Scanner;

public class SpaceBoxing {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Please enter your current earth weight: ");
        String enterWeight = scanner.nextLine();
        int earthWeight = Integer.parseInt(enterWeight);

        System.out.println("I have information for the following planets:");
        System.out.println("\t 1. Venus \t 2. Mars \t 3. Jupiter");
        System.out.println("\t 4. Saturn \t 5. Uranus \t 6. Neptune");

        System.out.println("Which planet are you visiting?");
        String planetString = scanner.nextLine();
        int planetNumber = Integer.parseInt(planetString);

        float venus = 0.78f * earthWeight;
        float mars = 0.39f * earthWeight;
        float jupiter = 2.65f * earthWeight;
        float saturn = 1.17f * earthWeight;
        float uranus = 1.05f * earthWeight;
        float neptune = 1.23f * earthWeight;



        if (planetNumber == 1){
            System.out.printf("Your weight would be %.02f pounds on that planet." , venus);
        } else if (planetNumber == 2){
            System.out.printf("Your weight would be %.02f pounds on that planet." , mars);
        } else if (planetNumber == 3){
            System.out.printf("Your weight would be %.02f pounds on that planet." , jupiter);
        }else if (planetNumber == 4){
            System.out.printf("Your weight would be %.02f pounds on that planet." , saturn);
        } else if (planetNumber == 5){
            System.out.printf("Your weight would be %.02f pounds on that planet." , uranus);
        }else if (planetNumber == 6){
            System.out.printf("Your weight would be %.02f pounds on that planet." , neptune);
        } else {
            System.out.println("You entered an invalid number");
        }



    }

}
