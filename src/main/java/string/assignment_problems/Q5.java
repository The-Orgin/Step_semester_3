import java.util.Scanner;

public class Q5 {
    static abstract class Appliance {
        double hours;
        boolean saver;
        Appliance(double h, boolean s) { hours = h; saver = s; }
        abstract double getPower();
        abstract boolean supportsSaver();
        abstract String getType();
        double getUnits() {
            if (saver && !supportsSaver()) return -1;
            double u = (getPower() * hours) / 1000.0;
            if (saver) u *= 0.75;
            return u;
        }
    }
    static class Fridge extends Appliance {
        Fridge(double h, boolean s) { super(h, s); }
        double getPower() { return 150.0; }
        boolean supportsSaver() { return false; }
        String getType() { return "FRIDGE"; }
    }
    static class AC extends Appliance {
        AC(double h, boolean s) { super(h, s); }
        double getPower() { return 1500.0; }
        boolean supportsSaver() { return true; }
        String getType() { return "AC"; }
    }
    static class TV extends Appliance {
        TV(double h, boolean s) { super(h, s); }
        double getPower() { return 100.0; }
        boolean supportsSaver() { return false; }
        String getType() { return "TV"; }
    }
    static class Washer extends Appliance {
        Washer(double h, boolean s) { super(h, s); }
        double getPower() { return 500.0; }
        boolean supportsSaver() { return true; }
        String getType() { return "WASHER"; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine();
        Appliance[] apps = new Appliance[n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");
            String type = parts[0];
            double h = Double.parseDouble(parts[1]);
            boolean s = parts.length > 2 && parts[2].equals("SAVER");
            if (type.equals("FRIDGE")) apps[i] = new Fridge(h, s);
            else if (type.equals("AC")) apps[i] = new AC(h, s);
            else if (type.equals("TV")) apps[i] = new TV(h, s);
            else apps[i] = new Washer(h, s);
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double u = apps[i].getUnits();
            if (u < 0) {
                System.out.printf("%s: saver mode not supported\n", apps[i].getType());
            } else {
                double cost = u * 8.0;
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", apps[i].getType(), u, cost);
                total += cost;
            }
        }
        System.out.printf("Total Cost: %.2f\n", total);
        scanner.close();
    }
}
