package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LocatingLargestValueArrayList {

    public static void main(String[] args) {


        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();

        do {
            numbers.add(random.nextInt(100) + 1);
        } while (numbers.size() < 10);


        System.out.println( "ArrayList: " + numbers + "\n");


        int index = 0;

        for (int i = 0; i < numbers.size(); i++ ){
            if (Collections.max(numbers) == numbers.get(i)){
                index = i;
            }

        }

        System.out.println("The largest value is: " + Collections.max(numbers) + ", which is in slot " + index);


    }
}
