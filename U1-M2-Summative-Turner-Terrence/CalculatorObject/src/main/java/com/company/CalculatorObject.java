package com.company;

public class CalculatorObject {

    public static int add(int a, int b){
        return a + b;
    }

    public static double add(double a, double b){
        return a + b;
    }

    public static int subtract(int a, int b){
        return a - b;
    }

    public static double subtract(double a, double b){
        return a - b;
    }

    public static int multiply(int a, int b){
        return a * b;
    }

    public static double multiply(double a, double b){
        return a * b;
    }

    public static int divide(int a, int b){
        return a / b;
    }

    public static double divide(double a, double b){
        return a / b;
    }



    public static void main(String[] args) {
        CalculatorObject calculatorObject = new CalculatorObject();

        System.out.println(calculatorObject.add(1, 1));
        System.out.println(calculatorObject.subtract(23, 52));
        System.out.println(calculatorObject.multiply(34,2));
        System.out.println(calculatorObject.divide(12,3));
        System.out.println(calculatorObject.divide(12,7));
        System.out.println(calculatorObject.add(3.4,2.3));
        System.out.println(calculatorObject.multiply(6.7,4.4));
        System.out.println(calculatorObject.subtract(5.5,0.5));
        System.out.println(calculatorObject.divide(10.8,2.2));




    }

}
