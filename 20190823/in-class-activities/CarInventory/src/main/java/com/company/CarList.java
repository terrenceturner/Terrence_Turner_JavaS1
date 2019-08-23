package com.company;

import java.util.*;


public class CarList {

    //Add car to list method
    public static void addCar(ArrayList<Car> cars) {

        try {

            Scanner scanner = new Scanner(System.in);

            char exit = 'Y';

            while (exit == 'Y') {

                //Adding cars to inventory
                System.out.println("Add a car.");
                System.out.println("Enter make: ");
                String userMake = scanner.nextLine();
                String make = userMake;

                System.out.println("Enter model: ");
                String userModel = scanner.nextLine();
                String model = userModel;

                System.out.println("Enter year: ");
                String userYear = scanner.nextLine();
                int year = Integer.parseInt(userYear);

                System.out.println("Enter color: ");
                String userColor = scanner.nextLine();
                String color = userColor;

                System.out.println("Enter miles: ");
                String userMiles = scanner.nextLine();
                int miles = Integer.parseInt(userMiles);

                cars.add(new Car(make, model, year, color, miles));
                System.out.print("Add another car? (y/n) \n");

                String userChoice = scanner.nextLine();
                exit = userChoice.toUpperCase().charAt(0);
            }


        } catch (InputMismatchException e) {

            System.out.println("Invalid input. Please try again. " + e.getMessage());
        }

        return;
    }

    //Delete car method
    public static void deleteCar(ArrayList<Car> cars) {

        try {

            Scanner scanner = new Scanner(System.in);

            char exit = 'Y';

            while (exit == 'Y') {

                System.out.println("Choose an index to delete from inventory");
                String userIndex = scanner.nextLine();
                int index = Integer.parseInt(userIndex);

                cars.remove(index);

                System.out.println("Delete another car? (y/n \n");

                String userDelete = scanner.nextLine();
                exit = userDelete.toUpperCase().charAt(0);
            }

            for (Car car : cars) {
                System.out.println(car);
            }

        } catch (InputMismatchException e) {

            System.out.println("Invalid input. Please try again. " + e.getMessage());
        }

        return;
    }

    //Show cars method
    public static void showCars(ArrayList<Car> Cars) {

        try{

            System.out.println("Here's the list of cars in the inventory.\n");
            for (int i = 0; i < Cars.size(); i++) {
                System.out.println(Cars.get(i));
            }

        } catch (InputMismatchException e) {

            System.out.println("Invalid input. Please try again. " + e.getMessage());
        }

        return;
    }

    //Search by make method
    public static void makeSearch(ArrayList<Car> cars) {

        try {

            Scanner scanner = new Scanner(System.in);

            char exit = 'Y';

            while (exit == 'Y') {

                System.out.println("Which brand are you looking for? ");
                String make = scanner.nextLine();
                cars.stream().filter(car -> car.getMake().equals(make)).forEach(car -> {
                    System.out.println("__________________________\n");
                    System.out.println("Make: " + car.getMake());
                    System.out.println("Model: " + car.getModel());
                    System.out.println("Year: " + car.getYear());
                    System.out.println("Color: " + car.getColor());
                    System.out.println("Miles: " + car.getMiles());

                });

                System.out.print("Search for another brand? (y/n) \n");
                String userBrand = scanner.nextLine();

                exit = userBrand.toUpperCase().charAt(0);
            }

        } catch (InputMismatchException e) {

            System.out.println("Invalid input. Please try again. " + e.getMessage());
        }

        return;
    }

    //Search by model method
    public static void modelSearch(ArrayList<Car> cars) {

        try {

            Scanner scanner = new Scanner(System.in);
            char exit = 'Y';

            while (exit == 'Y') {

                System.out.println("Which car model are you looking for? ");
                String model = scanner.nextLine();
                cars.stream().filter(car -> car.getModel().equals(model)).forEach(car -> {
                    System.out.println("__________________________\n");
                    System.out.println("Make: " + car.getMake());
                    System.out.println("Model: " + car.getModel());
                    System.out.println("Year: " + car.getYear());
                    System.out.println("Color: " + car.getColor());
                    System.out.println("Miles: " + car.getMiles());

                });

                System.out.print("Search for another model? (y/n) \n");

                String userModel = scanner.nextLine();
                exit = userModel.toUpperCase().charAt(0);
            }

        } catch (InputMismatchException e) {

            System.out.println("Invalid input. Please try again. "  + e.getMessage());
        }

        return;
    }

    //Search by color method
    public static void colorSearch(ArrayList<Car> cars) {

        try{

            Scanner scanner = new Scanner(System.in);
            char exit = 'Y';

            while (exit == 'Y') {

                System.out.println("Which color to search for? ");
                String color = scanner.nextLine();
                cars.stream().filter(car -> car.getColor().equals(color)).forEach(car -> {
                    System.out.println("__________________________\n");
                    System.out.println("Make: " + car.getMake());
                    System.out.println("Model: " + car.getModel());
                    System.out.println("Year: " + car.getYear());
                    System.out.println("Color: " + car.getColor());
                    System.out.println("Miles: " + car.getMiles());

                });

                System.out.print("Search for another color? (y/n) \n");

                String userColor = scanner.nextLine();
                exit = userColor.toUpperCase().charAt(0);
            }

        } catch (InputMismatchException e) {

            System.out.println("Invalid input. Please try again. " + e.getMessage());
        }

        return;
    }

    //Search by year method
    public static void yearSearch(ArrayList<Car> cars) {

        try{

            Scanner scanner = new Scanner(System.in);
            char exit = 'Y';

            while (exit == 'Y') {

                System.out.println("Enter year to search for car ");
                String yearInput = scanner.nextLine();
                int year = Integer.parseInt(yearInput);
                cars.stream().filter(car -> car.getYear() == (year)).forEach(car -> {
                    System.out.println("__________________________\n");
                    System.out.println("Make: " + car.getMake());
                    System.out.println("Model: " + car.getModel());
                    System.out.println("Year: " + car.getYear());
                    System.out.println("Color: " + car.getColor());
                    System.out.println("Miles: " + car.getMiles());

                });

                System.out.print("Search by year again? (y/n) \n");

                String userYear = scanner.nextLine();
                exit = userYear.toUpperCase().charAt(0);
            }

        } catch (InputMismatchException e) {

            System.out.println("Invalid input. Please try again. "  + e.getMessage());
        }

        return;
    }

    //Search by miles method
    public static void milesSearch(ArrayList<Car> cars) {

        try{

            Scanner scanner = new Scanner(System.in);

            char exit = 'Y';
            while (exit == 'Y') {

                System.out.println("Enter miles to search for cars with miles less than entered. ");
                String milesInput = scanner.nextLine();
                int miles = Integer.parseInt(milesInput);

                cars.stream().filter(car -> car.getMiles() < (miles)).forEach(car -> {
                    System.out.println("__________________________\n");
                    System.out.println("Make: " + car.getMake());
                    System.out.println("Model: " + car.getModel());
                    System.out.println("Year: " + car.getYear());
                    System.out.println("Color: " + car.getColor());
                    System.out.println("Miles: " + car.getMiles());

                });

                System.out.print("Search by miles again? (y/n) \n");

                String userMiles = scanner.nextLine();
                exit = userMiles.toUpperCase().charAt(0);
            }

        } catch (InputMismatchException e) {

            System.out.println("Invalid input. Please try again. " + e.getMessage());
        }

        return;
    }




}
