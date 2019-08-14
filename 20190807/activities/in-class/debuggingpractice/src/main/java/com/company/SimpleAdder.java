package com.company;

public class SimpleAdder {



    //Method Overloading
    public static int add(int a, int b){
        return a + b;
    }

    public static long add(long a, long b){
        return a + b;
    }

    public static double add(double a, double b){
        return a + b;
    }

    public static double add(float a, float b){
        return a + b;
    }



    public static void main(String[] args) {
        int i = 1;
        int j = 2;

        long long1 = 23;
        long long2 = 4;

        float float1 = 1.5f;
        float float2 = 2.1f;

        double d1 = 0.7d;
        double d2 = 4.4d;

        System.out.println(SimpleAdder.add(i, j));
        System.out.println(SimpleAdder.add(long1, long2));
        System.out.println(SimpleAdder.add(float1, float2));
        System.out.println(SimpleAdder.add(d1, d2));



    }

}
