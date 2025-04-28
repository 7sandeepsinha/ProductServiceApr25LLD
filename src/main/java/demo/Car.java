package demo;

public class Car extends Vehicle{
    public String fuelType;
    public String infotainmentModel;
    public int noOfSeats;
    public String transmissionType;

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getInfotainmentModel() {
        return infotainmentModel;
    }

    public void setInfotainmentModel(String infotainmentModel) {
        this.infotainmentModel = infotainmentModel;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }
}
