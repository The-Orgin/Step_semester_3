import java.util.Scanner;

public class Q5 {
    static abstract class Transport {
        double distance;
        Transport(double d) { this.distance = d; }
        abstract double getFare();
        abstract String getType();
    }
    static class Bus extends Transport {
        Bus(double d) { super(d); }
        double getFare() {
            double f = 2.0 + 0.10 * distance;
            return f > 10.0 ? 10.0 : f;
        }
        String getType() { return "BUS"; }
    }
    static class Train extends Transport {
        Train(double d) { super(d); }
        double getFare() { return 3.0 + 0.15 * distance; }
        String getType() { return "TRAIN"; }
    }
    static class Metro extends Transport {
        double peak;
        Metro(double d, double p) { super(d); this.peak = p; }
        double getFare() { return (1.50 + 0.20 * distance) * peak; }
        String getType() { return "METRO"; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Transport[] transports = new Transport[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double d = scanner.nextDouble();
            if (type.equals("BUS")) transports[i] = new Bus(d);
            else if (type.equals("TRAIN")) transports[i] = new Train(d);
            else transports[i] = new Metro(d, scanner.nextDouble());
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double f = transports[i].getFare();
            System.out.printf("%s: %.2f\n", transports[i].getType(), f);
            total += f;
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
