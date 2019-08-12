package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleClass {

    public static void main(String[] args) {


//        String aFruit = "Pinapple";
//
//        //Array
//        String[] fruits = {"apples", "oranges", "bananas"};
//
//
//        //    index =   [0][1] [2] [3]
//        //int[] numbers = {3, 9, 10, 11};
//
//        //------------
//
//
//        int[] arr1 = new int[4];
//
//        arr1[0] = 10;
//        arr1[1] = 20;
//        arr1[2] = 30;
//        //arr1[3] = 40;
//
//        //System.out.println(arr1[3]);
//
//
//       int[] arr2 = {10, 20, 30, 40};
//
//        arr2[3] = 100;
//       System.out.println(Arrays.deepToString(arr2[]));
//
//
//
////      Loop through array
//        for (int i = 0; i < arr2.length; i++){
//           // System.out.println(arr2[i]);
//        }
//
//        System.out.println("Simple form as follows");
//        for (int element:arr2){
//           // System.out.println(element);
//        }


        Scanner scanner = new Scanner(System.in);
//        int[] numbers = new int[10];
//
//        String stringIn;
//
//        int min;
//        int max;
//        int sum = 0;
//        double avg;
//
//        for (int i = 0; i < numbers.length; i++){
//            System.out.println("Please enter a number: ");
//            stringIn = scanner.nextLine();
//            numbers[i] = Integer.parseInt(stringIn);
//        }
//
//        //Calculate max
//        max = numbers[0];
//
//        for (int i = 0; i < numbers.length; i++){
//            if (numbers[i] > max){
//                max = numbers[i];
//            }
//        }
//
//        min = numbers[0];
//        for (int i = 0; i < numbers.length; i++){
//            if (numbers[i] < min){
//                min = numbers[i];
//            }
//        }
//
//        // Calculate average
//        for (int i= 0; i < numbers.length; i++){
//            sum += numbers[i];
//        }
//
//        avg = sum / (double) numbers.length;
//
//        System.out.println("Average is = " + avg);
//        System.out.println("Min: " + min);
//        System.out.println("Max: " + max);
//        System.out.println("Sum: " + sum);
//        System.out.println("Avg: " + avg);


//        String[][] multiArr = {
//
//                {"a", "b", "c"},
//                {"1", "2", "3"},
//                {"i", "ii", "iii"}
//        };
//
//        for (int i = 0; i < multiArr.length; i++){
//            for (int j = 0; j < multiArr[i].length; j++){
//                System.out.println(multiArr[i][j]);
//            }
//        }


        int[] arrInt = new int[4];
        arrInt[0] = 10;
        arrInt[1] = 20;
        arrInt[2] = 30;
        arrInt[3] = 40;



        for (int element:arrInt){
            System.out.println("Assign a value " + element);

        }



    }

}
