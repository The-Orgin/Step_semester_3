import java.util.Scanner;

public class Q5 {
    static abstract class Booking {
        double distance;
        Booking(double d) { distance = d; }
        abstract double getBaseFare();
        abstract String getType();
        double getTotal() { return getBaseFare() + 50.0; }
    }
    static class Bus extends Booking {
        Bus(double d) { super(d); }
        double getBaseFare() { return distance * 2.0; }
        String getType() { return "BUS"; }
    }
    static class Train extends Booking {
        Train(double d) { super(d); }
        double getBaseFare() { return distance * 1.5; }
        String getType() { return "TRAIN"; }
    }
    static class Flight extends Booking {
        Flight(double d) { super(d); }
        double getBaseFare() { return 2500.0 + (distance * 4.0); }
        String getType() { return "FLIGHT"; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Booking[] bookings = new Booking[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double d = scanner.nextDouble();
            if (type.equals("BUS")) bookings[i] = new Bus(d);
            else if (type.equals("TRAIN")) bookings[i] = new Train(d);
            else bookings[i] = new Flight(d);
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%s: %.2f\n", bookings[i].getType(), bookings[i].getTotal());
        }
        scanner.close();
    }
}
