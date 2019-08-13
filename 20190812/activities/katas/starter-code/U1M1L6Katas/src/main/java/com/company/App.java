package com.company;
import java.util.Scanner;
import java.util.Arrays;

public class App {
//total passed
    public static int total(int[] array1){
        int sum = 0;

        for (int i = 0; i < array1.length; i++){
            sum += array1[i];
        }

        return sum;

    }


    //total odds
    public static int totalOdd(int[] arrayOdds){

        int sumOfOdds = 0;

        for (int i = 0; i < arrayOdds.length; i++){

            if (i % 2 != 0){
                sumOfOdds += arrayOdds[i];
            }
        }

         return sumOfOdds;
    }

    //Total Even
    public static int totalEven(int[] arrayEvens){
        int sumEvens = 0;

        for (int i = 0; i < arrayEvens.length; i++){

            if (i % 2 == 0){
                sumEvens += arrayEvens[i];
            }
        }

        return sumEvens;
    }




// 2nd Largest
    public static int secondLargestNumber(int[] userArray) {

        int minNum = userArray[0];


        for (int i = 0; i <  userArray.length; i++) {

            if (userArray[i] < minNum) {
                minNum = userArray[i];
            }
        }

            int largestNumber = minNum;
            int secondLargestNumber = minNum;

            for (int i = 0; i <  userArray.length; i++){

                if (userArray[i] > largestNumber) {

                    secondLargestNumber = largestNumber;
                    largestNumber = userArray[i];

                } else if (userArray[i] > secondLargestNumber) {

                    secondLargestNumber = userArray[i];
                }

            }

        return secondLargestNumber;

    }


//Swap First and Last
    public static String[] swapFirstAndLast(String[] stringSwap){

        String newString = stringSwap[0];
        stringSwap[0] = stringSwap[stringSwap.length - 1];
        stringSwap[stringSwap.length - 1] = newString;

        return stringSwap;

    }



//reverse
    public static int[] reverse(int[] arrayNumbers){
        int[] arrayTemp = new int[arrayNumbers.length];
        int j = 0;


        for (int i = arrayNumbers.length - 1; i > -1; i--){
            arrayTemp[j] = arrayNumbers[i];
                j++;
        }

        for (int i = 0; i < arrayTemp.length; i++){

            arrayNumbers[i] = arrayTemp[i];
        }

        return arrayNumbers;

    }


//Concatenate String
    public static String concatenateString(String[] blendedString){

        String joinedString = "";

        for (int i = 0; i < blendedString.length; i++){
            joinedString += blendedString[i];
        }

        return  joinedString;

    }


    // Every 3rd
    public static int[] everyThird(int[] skipArray) {

        int[] thirdArray = new int[skipArray.length % 3];
        int j = 0;

        for (int i = 2; i < skipArray.length; i+=3){
            if (skipArray.length < 3){
                return null;
            } else {
                thirdArray[j] += skipArray[i];
                j++;

            }

            System.out.println(Arrays.toString(thirdArray));

        }

        return thirdArray;

    }


    public static int[] lessThanFive(int[] fiveArray){

        int[] newFiveArray = new int[fiveArray.length];
        int fiveLess = 0;
        int otherValue = 0;

        for (int i = 0; i < fiveArray.length; i++){

            if (fiveArray[i] < 5){
                fiveLess = fiveArray[i];

            }




            newFiveArray[i] = fiveLess;
            System.out.println(newFiveArray[i]);
//            System.out.println(otherValue);
        }

        return newFiveArray;

    }





    public static void main(String[] args) {

        int testArray[] = {23,1,10,5,7,6,2,17,15};

//        for (int i = 2; i < testArray.length; i+=3){
//            System.out.println(testArray[i]);
//        }

        //System.out.println(secondLargestNumber(testArray));

        String stringArray[] = {"billy", "bob", "thornton"};

        System.out.println(concatenateString(stringArray));

        System.out.println(everyThird(testArray));



    }









}
