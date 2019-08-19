package com.company;

public class IceCreamFactory {

    private String iceCreamFiller;
    private String iceCreamPackage;
    private String conveyorBelt;
    private int blendTanks;
    private int pasteurizer;
    private int homogenizer;
    private int storageTank;
    private int flavoringTank;
    private int freezer;


    public void fillIceCream(){

    }

    public void packageIceCream(){

    }

    public void distributeIceCream(){

    }

    public IceCreamFactory(String iceCreamFiller, String iceCreamPackage, String conveyorBelt, int blendTanks,
                           int pasteurizer, int homogenizer, int storageTank, int flavoringTank, int freezer) {
        this.iceCreamFiller = iceCreamFiller;
        this.iceCreamPackage = iceCreamPackage;
        this.conveyorBelt = conveyorBelt;
        this.blendTanks = blendTanks;
        this.pasteurizer = pasteurizer;
        this.homogenizer = homogenizer;
        this.storageTank = storageTank;
        this.flavoringTank = flavoringTank;
        this.freezer = freezer;
    }

    public String getIceCreamFiller() {
        return iceCreamFiller;
    }

    public void setIceCreamFiller(String iceCreamFiller) {
        this.iceCreamFiller = iceCreamFiller;
    }

    public String getIceCreamPackage() {
        return iceCreamPackage;
    }

    public void setIceCreamPackage(String iceCreamPackage) {
        this.iceCreamPackage = iceCreamPackage;
    }

    public String getConveyerBelt() {
        return conveyorBelt;
    }

    public void setConveyerBelt(String conveyerBelt) {
        this.conveyorBelt = conveyerBelt;
    }

    public int getBlendTanks() {
        return blendTanks;
    }

    public void setBlendTanks(int blendTanks) {
        this.blendTanks = blendTanks;
    }

    public int getPasteurizer() {
        return pasteurizer;
    }

    public void setPasteurizer(int pasteurizer) {
        this.pasteurizer = pasteurizer;
    }

    public int getHomogenizer() {
        return homogenizer;
    }

    public void setHomogenizer(int homogenizer) {
        this.homogenizer = homogenizer;
    }

    public int getStorageTank() {
        return storageTank;
    }

    public void setStorageTank(int storageTank) {
        this.storageTank = storageTank;
    }

    public int getFlavoringTank() {
        return flavoringTank;
    }

    public void setFlavoringTank(int flavoringTank) {
        this.flavoringTank = flavoringTank;
    }

    public int getFreezer() {
        return freezer;
    }

    public void setFreezer(int freezer) {
        this.freezer = freezer;
    }
}
