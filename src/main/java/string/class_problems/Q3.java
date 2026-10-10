import java.util.Scanner;

public class Q3 {
    static abstract class Delivery {
        double weight, distance;
        Delivery(double w, double d) { this.weight = w; this.distance = d; }
        abstract double getFee();
        abstract String getType();
    }
    static class Standard extends Delivery {
        Standard(double w, double d) { super(w, d); }
        double getFee() { return 5.0 + 0.5 * weight + 0.1 * distance; }
        String getType() { return "STANDARD"; }
    }
    static class Express extends Delivery {
        Express(double w, double d) { super(w, d); }
        double getFee() { return 15.0 + 1.0 * weight + 0.2 * distance; }
        String getType() { return "EXPRESS"; }
    }
    static class International extends Delivery {
        double customs;
        International(double w, double d, double c) { super(w, d); this.customs = c; }
        double getFee() { return 25.0 + 2.0 * weight + 0.5 * distance + customs; }
        String getType() { return "INTERNATIONAL"; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Delivery[] deliveries = new Delivery[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double w = scanner.nextDouble();
            double d = scanner.nextDouble();
            if (type.equals("STANDARD")) deliveries[i] = new Standard(w, d);
            else if (type.equals("EXPRESS")) deliveries[i] = new Express(w, d);
            else deliveries[i] = new International(w, d, scanner.nextDouble());
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double fee = deliveries[i].getFee();
            System.out.printf("%s: %.2f\n", deliveries[i].getType(), fee);
            total += fee;
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
