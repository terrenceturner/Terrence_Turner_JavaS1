package com.company;

import java.util.LinkedList;
import java.util.List;

public class LinkedListApp {

    public static int total(List<Integer> numbers){

        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }

        return sum;

    }


    public static int totalEven (List<Integer> numbers) {

        int sum = 0;
        for(int i = 0; i < numbers.size(); i += 2) {
            sum += numbers.get(i);
        }

        return sum;
    }


    public static List<String> swapFirstAndLast(List<String> strings) {

        String temp = strings.get(0);
        strings.set(0, strings.get(strings.size() - 1));
        strings.set(strings.size() - 1, temp);

        return strings;
    }

    public static List<Integer> reverse(List<Integer> numbers) {

        List<Integer> reversed = new LinkedList<Integer>();

        for(int i = numbers.size() - 1; i > -1; i--) {

            // length - (i + 1) is the n-th to last element
            // so when i = 0, it would be the last element
            // when i = 3, it would be the fourth to last element since i=3 is the 4th element, etc
            reversed.add(numbers.get(i));
        }

        return reversed;
    }

    public static List lessThanFive(List<Integer> numbers) {

        int numLessThanFive = 0;

        for(int num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            }
        }

        if ( numLessThanFive == 0 ) {
            return null;
        }

        List<Integer> lessThan = new LinkedList<Integer>() ;

        for(int num : numbers) {
            if ( num < 5 ) {

                // subtracting numLessThanFive from length then decrementing numLessThanFive
                // allows us to go from 0 to length - 1 in order without additional variables
                lessThan.set(lessThan.size() - numLessThanFive,  num);
                numLessThanFive--;
            }
        }

        return lessThan;
    }










}
