package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WhereIsIt {

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

        int index = 0;

        for (int i = 0; i < numbers.size(); i++ ){
            if (userValue == numbers.get(i)){
                index = i;
            }

        }

        if (numbers.contains(userValue)){
            System.out.println(userValue + " is in slot " + index);

        } else {
            System.out.println(userValue + " is not in the ArrayList.");
        }


    }

}
