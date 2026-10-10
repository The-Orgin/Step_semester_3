import java.util.Scanner;

public class Q4 {
    static abstract class Cab {
        double km;
        String time;
        Cab(double k, String t) { km = k; time = t; }
        abstract double getRate();
        abstract boolean supportsNight();
        abstract String getType();
        double getFare() {
            if (time.equals("NIGHT") && !supportsNight()) return -1;
            double base = km * getRate();
            if (base < 100.0) base = 100.0;
            if (time.equals("NIGHT")) base *= 1.20;
            return base;
        }
    }
    static class Mini extends Cab {
        Mini(double k, String t) { super(k, t); }
        double getRate() { return 10.0; }
        boolean supportsNight() { return false; }
        String getType() { return "MINI"; }
    }
    static class Sedan extends Cab {
        Sedan(double k, String t) { super(k, t); }
        double getRate() { return 14.0; }
        boolean supportsNight() { return true; }
        String getType() { return "SEDAN"; }
    }
    static class SUV extends Cab {
        SUV(double k, String t) { super(k, t); }
        double getRate() { return 18.0; }
        boolean supportsNight() { return true; }
        String getType() { return "SUV"; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Cab[] cabs = new Cab[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double k = scanner.nextDouble();
            String t = scanner.next();
            if (type.equals("MINI")) cabs[i] = new Mini(k, t);
            else if (type.equals("SEDAN")) cabs[i] = new Sedan(k, t);
            else cabs[i] = new SUV(k, t);
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double fare = cabs[i].getFare();
            if (fare < 0) {
                System.out.printf("%s: night service not available\n", cabs[i].getType());
            } else {
                System.out.printf("%s: %.2f\n", cabs[i].getType(), fare);
                total += fare;
            }
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
