package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists3 {

    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();

        do {
            numbers.add(random.nextInt(99) + 10);
        } while (numbers.size() < 1000);

        System.out.println( "ArrayList: " + numbers );


    }
}
