package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

public class App {

    public void printKeys(Map<String, String> keys){
        Set<Map.Entry<String, String>> myKeys = keys.entrySet();
        for (Map.Entry<String, String> entryKey:myKeys){
            System.out.println(entryKey);
        }
    }

    public void printValues(Map<String, String> values){
        Set<Map.Entry<String, String>> myValues = values.entrySet();
        for (Map.Entry<String, String> entryValue:myValues){
            System.out.println(entryValue);
        }
    }

    public void printKeysAndValues(Map<String, String> keysAndValues){
        Set<Map.Entry<String, String>> myKeysAndValues = keysAndValues.entrySet();
        for(Map.Entry<String, String> entry: keysAndValues.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    public Map<String, Integer> mapFun(Map<String, Integer> cars){

        Map<String, Integer> car = new HashMap<>();
        car.put("Toyota Camry", 2012);
        car.put("Chevy Camaro", 1969);
        car.put("Hyundai Genesis", 2015);
        car.put("Jeep Wrangler", 2003);
        car.put("Honda Civic", 2018);
        car.put("Toyota Supra", 1995);
        car.put("Pontiac GTO", 1964);


        car.put("Ford Explorer", 2012);
        car.put("Smart Fortwo", 2013);


        car.remove("Jeep Wrangler");

        return cars;

    }


    public Map<String, List<Car>> listCars(Map<String, List> Car){
        List<Car> toyotaList = new ArrayList<>();
        for (Car toyota: toyotaList) {
            System.out.println("Make: " + toyota.getMake() + "\tModel: " + toyota.getModel());
        }

        List<Car> hondaList = new ArrayList<>();
        for (Car honda: toyotaList) {
            System.out.println("Make: " + honda.getMake() + "\tModel: " + honda.getModel());
        }

        List<Car> fordList = new ArrayList<>();
        for (Car ford: toyotaList) {
            System.out.println("Make: " + ford.getMake() + "\tModel: " + ford.getModel());
        }


        return null;
    }



    public static void main(String[] args) {

        Car camry = new Car("Toyota", "Camry");
        Car supra = new Car("Toyota", "Supra");
        Car explorer = new Car("Ford", "Explorer");
        Car civic = new Car("Honda", "Civic");



        List<Car> toyotaList = new ArrayList<>();
        toyotaList.add(camry);
        toyotaList.add(supra);
        for (Car toyota: toyotaList) {
            System.out.println("Make: " + toyota.getMake() + "\tModel: " + toyota.getModel());
        }

        List<Car> hondaList = new ArrayList<>();
        hondaList.add(civic);
        for (Car honda: hondaList) {
            System.out.println("Make: " + honda.getMake() + "\tModel: " + honda.getModel());
        }

        List<Car> fordList = new ArrayList<>();
        fordList.add(explorer);
        for (Car ford: fordList) {
            System.out.println("Make: " + ford.getMake() + "\tModel: " + ford.getModel());
        }


        Map<String, List> carList = new HashMap<>();
        carList.put("Toyota",toyotaList);
        carList.put("Ford", fordList);
        carList.put("Honda", hondaList);


    }


    
}
