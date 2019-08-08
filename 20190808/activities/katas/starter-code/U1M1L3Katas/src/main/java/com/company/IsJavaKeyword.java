package com.company;

import java.util.Scanner;

public class IsJavaKeyword {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word");
        String userInput = scanner.nextLine();




        switch (userInput){
            case ("abstract"):
                System.out.println("is a java keyword");
                break;
            case ("byte"):
                System.out.println("is a java keyword");
                break;
            case ("class"):
                System.out.println("is a java keyword");
                break;
            case ("do"):
                System.out.println("is a java keyword");
                break;
            case ("extends"):
                System.out.println("is a java keyword");
                break;
            case ("for"):
                System.out.println("is a java keyword");
                break;
            case ("while"):
                System.out.println("is a java keyword");
                break;
            default:
                System.out.println("not a java keyword");
        }



    }
}
