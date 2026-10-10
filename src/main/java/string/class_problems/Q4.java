import java.util.Scanner;

public class Q4 {
    static abstract class Connection {
        int units;
        Connection(int u) { units = u; }
        abstract double getBill();
        abstract String getType();
    }
    static class Home extends Connection {
        Home(int u) { super(u); }
        double getBill() {
            if (units <= 100) return units * 5.0;
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
        String getType() { return "HOME"; }
    }
    static class Shop extends Connection {
        Shop(int u) { super(u); }
        double getBill() { return (units * 8.0) + 100.0; }
        String getType() { return "SHOP"; }
    }
    static class Factory extends Connection {
        Factory(int u) { super(u); }
        double getBill() {
            double b = units * 6.0;
            return b < 1000.0 ? 1000.0 : b;
        }
        String getType() { return "FACTORY"; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Connection[] cons = new Connection[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int u = scanner.nextInt();
            if (type.equals("HOME")) cons[i] = new Home(u);
            else if (type.equals("SHOP")) cons[i] = new Shop(u);
            else cons[i] = new Factory(u);
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double b = cons[i].getBill();
            System.out.printf("%s: %.2f\n", cons[i].getType(), b);
            total += b;
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
