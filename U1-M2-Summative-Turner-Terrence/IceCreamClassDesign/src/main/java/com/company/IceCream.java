package com.company;

public class IceCream {


    private int waffleCones;
    private int waffleBowls;
    private String freezerBrand;
    private int employees;
    private int iceCreamScoops;
    private String cashierMachine;
    private int spoons;
    private int napkins;

    public void scoopIceCream(){

    }

    public void sellIceCream(){

    }

    public IceCream(int waffleCones, int waffleBowls, String freezerBrand, int employees, int iceCreamScoops,
                    String cashierMachine, int spoons, int napkins) {
        this.waffleCones = waffleCones;
        this.waffleBowls = waffleBowls;
        this.freezerBrand = freezerBrand;
        this.employees = employees;
        this.iceCreamScoops = iceCreamScoops;
        this.cashierMachine = cashierMachine;
        this.spoons = spoons;
        this.napkins = napkins;
    }

    public int getWaffleCones() {
        return waffleCones;
    }

    public void setWaffleCones(int waffleCones) {
        this.waffleCones = waffleCones;
    }

    public int getWaffleBowls() {
        return waffleBowls;
    }

    public void setWaffleBowls(int waffleBowls) {
        this.waffleBowls = waffleBowls;
    }

    public String getFreezerBrand() {
        return freezerBrand;
    }

    public void setFreezerBrand(String freezerBrand) {
        this.freezerBrand = freezerBrand;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public int getIceCreamScoops() {
        return iceCreamScoops;
    }

    public void setIceCreamScoops(int iceCreamScoops) {
        this.iceCreamScoops = iceCreamScoops;
    }

    public String getCashierMachine() {
        return cashierMachine;
    }

    public void setCashierMachine(String cashierMachine) {
        this.cashierMachine = cashierMachine;
    }

    public int getSpoons() {
        return spoons;
    }

    public void setSpoons(int spoons) {
        this.spoons = spoons;
    }

    public int getNapkins() {
        return napkins;
    }

    public void setNapkins(int napkins) {
        this.napkins = napkins;
    }
}
