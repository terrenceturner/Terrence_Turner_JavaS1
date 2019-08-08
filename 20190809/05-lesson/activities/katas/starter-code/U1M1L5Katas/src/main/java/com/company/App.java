package com.company;

public class App {


    public static int subtract(int a, int b){
        return a - b;
    }


    public static int subtractOrZero(int a, int b){

        if ((a - b) < 0){
            return 0;
        } else {
            return a - b;
        }

    }


    public static int max( int a, int b, int c){

        if ((a > b) && (a > c)){
            return a;
        } else if ((b > a) && (b > c)){
            return b;
        } else {
            return c;
        }

    }


    public static int min(int a, int b, int c){

        if ((a < b) && (a < c)){
            return a;
        } else if ((b < a) && (b < c)){
            return b;
        } else {
            return c;
        }

    }


    public static boolean isLarger(int first, int second){


        if (first > second){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println(subtract(19, 5));

        System.out.println(min(2, 34, 19));

        System.out.println(max(24, 38, 15));

        System.out.println(isLarger(85, 62));

        System.out.println(subtractOrZero(23, 8));
    }


}
