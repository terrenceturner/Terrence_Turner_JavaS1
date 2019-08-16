package com.company.composition;

public class GiftCard {


    private String serialNumber;

    private double currentBalance;
    private double originalBalance;


    public GiftCard(String serialNumber, double originalBalance){
        this.serialNumber = serialNumber;
        this.currentBalance = originalBalance;
        this.originalBalance = originalBalance;
    }


    public String getSerialNumber() {
        return serialNumber;
    }


    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getOriginalBalance() {
        return originalBalance;
    }


}
