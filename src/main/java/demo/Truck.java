package demo;

public class Truck extends Vehicle {
    public int loadCarryingCapacity;
    public int noOfWheels;
    public int range;

    public int getLoadCarryingCapacity() {
        return loadCarryingCapacity;
    }

    public void setLoadCarryingCapacity(int loadCarryingCapacity) {
        this.loadCarryingCapacity = loadCarryingCapacity;
    }

    public int getNoOfWheels() {
        return noOfWheels;
    }

    public void setNoOfWheels(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
