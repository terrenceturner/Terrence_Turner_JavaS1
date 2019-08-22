package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class BasicArrayLists2 {




    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();

        do {
            numbers.add(random.nextInt(100) + 1);
        } while (numbers.size() < 10);


        System.out.println( "ArrayList: " + numbers );
    }

}
