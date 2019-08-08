package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("How old are you");
        int age = Integer.parseInt(scanner.nextLine());

        if (age < 14){
            System.out.println("What grade are you in? ");
            String grade = scanner.nextLine();
            System.out.println("Wow! " + grade + " grade - that sounds exciting!");

        } else if (age >= 14 && age <= 18){
            System.out.println("Are you going to college?");
            String answer = scanner.nextLine();
            if (answer.equals("yes")){
                System.out.println("What college?");
                String college = scanner.nextLine();
                System.out.println(college + " is a great school!");
            } else if (answer.equals("no")){
                System.out.println("What do you want to do after high school?");
                String userAnswer = scanner.nextLine();
                System.out.println("Wow, " + userAnswer + " sounds like a plan!");
            } else {
                System.out.println("invalid answer");
            }

        } else if (age > 18){
            System.out.println("What is your job? ");
            String job = scanner.nextLine();
            System.out.println(job + " sounds like a great job!");
        } else {
            System.out.println("Invalid answer");
        }
    }
}
