import java.util.Scanner;

public class Q2 {
    static abstract class Parcel {
        double weight, value;
        Parcel(double w, double v) { weight = w; value = v; }
        abstract double getCharge();
        abstract double getInsurance();
        abstract String getType();
    }
    static class Standard extends Parcel {
        Standard(double w, double v) { super(w, v); }
        double getCharge() { return 40.0 + 10.0 * weight; }
        double getInsurance() { return 0.0; }
        String getType() { return "STANDARD"; }
    }
    static class Express extends Parcel {
        Express(double w, double v) { super(w, v); }
        double getCharge() { return 80.0 + 15.0 * weight; }
        double getInsurance() { return value * 0.02; }
        String getType() { return "EXPRESS"; }
    }
    static class Fragile extends Parcel {
        Fragile(double w, double v) { super(w, v); }
        double getCharge() { return 40.0 + 10.0 * weight + 50.0; }
        double getInsurance() { return value * 0.02; }
        String getType() { return "FRAGILE"; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Parcel[] parcels = new Parcel[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double w = scanner.nextDouble();
            double v = scanner.nextDouble();
            if (type.equals("STANDARD")) parcels[i] = new Standard(w, v);
            else if (type.equals("EXPRESS")) parcels[i] = new Express(w, v);
            else parcels[i] = new Fragile(w, v);
        }
        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            double c = parcels[i].getCharge();
            double ins = parcels[i].getInsurance();
            double t = c + ins;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", parcels[i].getType(), c, ins, t);
            grandTotal += t;
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
        scanner.close();
    }
}
