package demo;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Truck truck = new Truck();
        Bike bike = new Bike();

        System.out.println("Car model : " + car.getModel());
        System.out.println("Bike model : " + bike.getModel());
        System.out.println("Truck model : " + truck.getModel());
    }
}
