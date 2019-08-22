package com.company;

import java.util.*;

public class FindingAValueInAnArrayList {

    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();

        do {
            numbers.add(random.nextInt(50) + 1);
        } while (numbers.size() < 10);

        System.out.println( "ArrayList: " + numbers );

        System.out.println("Enter a value to find: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        int userValue = Integer.parseInt(userInput);



        if (numbers.contains(userValue)){
            System.out.println(userValue + " is in the ArrayList.");
        } else {
            System.out.println("Value not found.");
        }



    }

}
