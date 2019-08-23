package com.company;

public class ConverterIf implements Converter {


    @Override
    public String convertMonth(int monthNumber) {
        if (monthNumber == 1){
            System.out.println("January");
        } else if (monthNumber == 2){
            System.out.println("February");
        } else if (monthNumber == 3){
            System.out.println("March");
        } else if (monthNumber == 4){
            System.out.println("April");
        } else if (monthNumber == 5){
            System.out.println("May");
        } else if (monthNumber == 6){
            System.out.println("June");
        } else if (monthNumber == 7){
            System.out.println("July");
        } else if (monthNumber == 8){
            System.out.println("August");
        } else if (monthNumber == 9){
            System.out.println("September");
        } else if (monthNumber == 10){
            System.out.println("October");
        } else if (monthNumber == 11){
            System.out.println("November");
        } else if (monthNumber == 12){
            System.out.println("December");
        } else {
            System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
        }
        return "";
    }

    @Override
    public String convertDay(int dayNumber) {

        if (dayNumber == 1){
            System.out.println("Sunday");
        } else if (dayNumber == 2){
            System.out.println("Monday");
        } else if (dayNumber == 3){
            System.out.println("Tuesday");
        } else if (dayNumber == 4){
            System.out.println("Wednesday");
        } else if (dayNumber == 5){
            System.out.println("Thursday");
        } else if (dayNumber == 6){
            System.out.println("Friday");
        } else if (dayNumber == 7){
            System.out.println("Saturday");
        } else {
            System.out.println("You have entered an invalid number. You must enter a number between 1 and 7. Goodbye.");
        }

        return "";

    }
}
