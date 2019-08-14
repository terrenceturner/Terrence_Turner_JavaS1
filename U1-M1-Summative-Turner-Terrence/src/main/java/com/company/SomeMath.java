package com.company;

public class SomeMath {


    // total
    public static int total5(int a, int b, int c, int d, int e){
        int sum = a + b + c + d + e;
        return sum;
    }

    // Average
    public static int average5(int a, int b, int c, int d, int e){
        int total = a + b + c + d + e;
        int average = total / 5;

        return average;
    }

    // Largest Double
    public static double largest5(double a, double b, double c, double d, double e){

        if ((a > b) && (a > c) && (a > d) && (a > e)){
            return a;
        } else if ((b > a) && (b > c) && (b > d) && (b > e)){
            return b;
        } else if ((c > a) && (c > b) && (c > d) && (c > e)){
            return c;
        } else if ((d > a) && (d > b) && (d > c) && (d > e)){
            return d;
        } else {
            return e;
        }
    }


    public static void main(String[] args) {

        System.out.println("Total is: " + total5(1, 2, 3, 4, 5));

        System.out.println("Average is: " + average5(1, 3, 5, 7, 9));

        System.out.println("The largest number is: " + largest5(42.0, 35.1, 2.3, 40.2, 15.6));
    }
}
