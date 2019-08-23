package com.company;

import java.util.*;


public class App {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Car> cars = new ArrayList<>();

        //Title
        System.out.println("Welcome to Car Design and Inventory.");
        System.out.println("_____________________________________");

        while (true) {

            //Menu Options
            System.out.println("\nChoose an option below: ");
            System.out.println("ADD = Add Car to Inventory | DEL = Delete a Car from Inventory | SHOW = Show all cars in Inventory ");
            System.out.println("MAKE = Search by make | MODEL = Search by model | YEAR = Search cars by year | COLOR = Search by color");
            System.out.println("MILES = Search for cars with miles less than entered ");
            System.out.println("QUIT = Quit the Program");
            System.out.print("> ");

            String choice = scan.next().toUpperCase();
            switch (choice) {
                case "ADD":
                    CarList.addCar(cars);
                    break;
                case "DEL":
                    CarList.deleteCar(cars);
                    break;
                case "SHOW":
                    CarList.showCars(cars);
                    break;
                case "MAKE":
                    CarList.makeSearch(cars);
                    break;
                case "MODEL":
                    CarList.modelSearch(cars);
                    break;
                case "COLOR":
                    CarList.colorSearch(cars);
                    break;
                case "YEAR":
                    CarList.yearSearch(cars);
                    break;
                case "MILES":
                    CarList.milesSearch(cars);
                    break;
                case "QUIT":
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Answer");
            }

        }
    }

}
