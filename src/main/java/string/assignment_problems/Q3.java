import java.util.Scanner;

public class Q3 {
    static abstract class Room {
        int units;
        Room(int u) { units = u; }
        abstract double getBill();
        abstract String getType();
    }
    static class Single extends Room {
        Single(int u) { super(u); }
        double getBill() { return units * 8.0; }
        String getType() { return "SINGLE"; }
    }
    static class Shared extends Room {
        int occupants;
        Shared(int u, int o) { super(u); occupants = o; }
        double getBill() { return (units * 6.0) / occupants; }
        String getType() { return "SHARED"; }
    }
    static class AC extends Room {
        AC(int u) { super(u); }
        double getBill() { return (units * 10.0) + 200.0; }
        String getType() { return "AC"; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Room[] rooms = new Room[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int u = scanner.nextInt();
            if (type.equals("SINGLE")) rooms[i] = new Single(u);
            else if (type.equals("SHARED")) rooms[i] = new Shared(u, scanner.nextInt());
            else rooms[i] = new AC(u);
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double b = rooms[i].getBill();
            System.out.printf("%s: %.2f\n", rooms[i].getType(), b);
            total += b;
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
