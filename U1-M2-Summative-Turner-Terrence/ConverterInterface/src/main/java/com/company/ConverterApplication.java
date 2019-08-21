package com.company;

import java.util.Scanner;

public class ConverterApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ConverterIf converterIf = new ConverterIf();
        ConverterSwitch converterSwitch = new ConverterSwitch();


        System.out.println("Enter a number between 1 and 12 for month: ");
        int userMonth = scanner.nextInt();


        System.out.println("Enter a number between 1 and 7 for day: ");
        int userDay = scanner.nextInt();



        System.out.println(converterIf.convertMonth(userMonth));
        System.out.println(converterSwitch.convertMonth(userMonth));

        System.out.println(converterIf.convertDay(userDay));
        System.out.println(converterSwitch.convertDay(userDay));


    }
}
