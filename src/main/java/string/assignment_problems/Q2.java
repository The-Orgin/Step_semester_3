import java.util.Scanner;

public class Q2 {
    static abstract class Vehicle {
        int hours;
        Vehicle(int h) { hours = h; }
        abstract double getCharge();
        abstract String getType();
    }
    static class Bike extends Vehicle {
        Bike(int h) { super(h); }
        double getCharge() { return 10.0 * hours; }
        String getType() { return "BIKE"; }
    }
    static class Car extends Vehicle {
        Car(int h) { super(h); }
        double getCharge() { return 30.0 + (hours > 1 ? (hours - 1) * 20.0 : 0); }
        String getType() { return "CAR"; }
    }
    static class Truck extends Vehicle {
        Truck(int h) { super(h); }
        double getCharge() {
            double c = 50.0 * hours;
            return c < 100.0 ? 100.0 : c;
        }
        String getType() { return "TRUCK"; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Vehicle[] vehicles = new Vehicle[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int h = scanner.nextInt();
            if (type.equals("BIKE")) vehicles[i] = new Bike(h);
            else if (type.equals("CAR")) vehicles[i] = new Car(h);
            else vehicles[i] = new Truck(h);
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double c = vehicles[i].getCharge();
            System.out.printf("%s: %.2f\n", vehicles[i].getType(), c);
            total += c;
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
