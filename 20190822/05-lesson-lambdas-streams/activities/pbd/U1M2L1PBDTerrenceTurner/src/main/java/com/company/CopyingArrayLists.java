package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CopyingArrayLists {

    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();

        do {
            numbers.add(random.nextInt(100) + 1);
        } while (numbers.size() < 10);

        List<Integer> numbers1 = new ArrayList<>();
        for (Integer number : numbers){
            numbers1.add(number);
        }

        //remove last index and replace with -7 for first Array
        numbers.remove(9);
        numbers.add(-7);


        System.out.println("ArrayList 1: " + numbers );
        System.out.println("ArrayList 2: " + numbers1);


    }

}
