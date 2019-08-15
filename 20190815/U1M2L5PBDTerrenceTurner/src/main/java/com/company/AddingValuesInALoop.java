package com.company;

import java.util.Scanner;

public class AddingValuesInALoop {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sum = 0;



        System.out.println("I will add up the numbers you give me.");
        int userNum = scanner.nextInt();


        while (userNum != 0) {


            System.out.println("Number: " + userNum);
            //sum = sum + userNum
            sum += userNum ;

            System.out.println("Total so far is " + sum );
            userNum = scanner.nextInt();



        }
    }



}
