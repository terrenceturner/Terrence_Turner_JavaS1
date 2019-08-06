package com.company;
import java.util.Scanner;

public class CommandLineGram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Command Line Gram \n");
        System.out.println("What's your First Name? ");
        String firstName = scanner.nextLine();

        System.out.println("What's your Last Name? ");
        String lastName = scanner.nextLine();

        System.out.println("Enter your email: ");
        String email = scanner.nextLine();

        System.out.println("Enter your twitter handle: ");
        String twitter = scanner.nextLine();

        System.out.println("What's your age? ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("What country are you from? ");
        String country = scanner.nextLine();

        System.out.println("What is your profession? ");
        String profession = scanner.nextLine();

        System.out.println("What is your favorite operating system? ");
        String operatingSystem = scanner.nextLine();

        System.out.println("What is your favorite programming language? ");
        String programmingLanguage = scanner.nextLine();

        System.out.println("Who is your favorite computer scientist? ");
        String scientist = scanner.nextLine();

        System.out.println("What is your favorite keyboard shortcut? ");
        String shortcut = scanner.nextLine();

        System.out.println("Have you ever built your own computer? yes%/no? ");
        String yesOrNo = scanner.nextLine();

        System.out.println("If you could be a superhero, who would it be? ");
        String hero = scanner.nextLine();

        System.out.printf("First Name: %s \n", firstName);
        System.out.printf("Last Name: %s \n", lastName);
        System.out.printf("Email: %s \n", email);
        System.out.printf("Twitter handle: %s \n", twitter);
        System.out.printf("Age: %d \n", age);
        System.out.printf("Country: %s \n", country);
        System.out.printf("Profession: %s \n", profession);
        System.out.printf("OS: %s \n", operatingSystem);
        System.out.printf("Programming Language: %s \n", programmingLanguage);
        System.out.printf("Computer Scientist: %s \n", scientist);
        System.out.printf("Keyboard Shortcut: %s \n", shortcut);
        System.out.printf("Built Computer: %s \n", yesOrNo);
        System.out.printf("Superhero: %s \n", hero);



    }
}
