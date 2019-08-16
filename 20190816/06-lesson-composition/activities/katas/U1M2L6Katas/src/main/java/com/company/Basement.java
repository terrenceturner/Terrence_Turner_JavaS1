package com.company;

public class Basement {

    private boolean isFinished;
    private boolean hasBathroom;
    private String hotWaterTank;
    private boolean hasStorage;

    public void lightsOn(){

    }

    public void lightsOff(){

    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public boolean isHasBathroom() {
        return hasBathroom;
    }

    public void setHasBathroom(boolean hasBathroom) {
        this.hasBathroom = hasBathroom;
    }

    public String getHotWaterTank() {
        return hotWaterTank;
    }

    public void setHotWaterTank(String hotWaterTank) {
        this.hotWaterTank = hotWaterTank;
    }

    public boolean isHasStorage() {
        return hasStorage;
    }

    public void setHasStorage(boolean hasStorage) {
        this.hasStorage = hasStorage;
    }
}
