package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GettingIndividualDigits {

    public static int sum(int i, int j){
        return i + j;

    }

    public static int[] squareUp(int n) {

        int[] array = new int[n*n];

        if (n == 0){
            return array;
        }

        for (int i = n - 1; i < array.length; i+=n ){

            for(int j = i; j >= i - i / n; j--){
                array[j] = i - j + 1;
            }


        }

        return array;
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 9; i++){
            for (int j = 0; j <= 9; j++){
                System.out.println("" + i + j + ", " + i + "+" + j + " = " + sum(i,j));

            }
        }

        System.out.println("\n");
        System.out.println(Arrays.toString(squareUp(12)));

    }



}


