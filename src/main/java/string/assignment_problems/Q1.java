import java.util.Scanner;

public class Q1 {
    static abstract class Ticket {
        int count;
        Ticket(int count) { this.count = count; }
        abstract double getPrice();
        abstract String getType();
        double getTotal() { return (getPrice() + 20.0) * count; }
    }
    static class Regular extends Ticket {
        Regular(int c) { super(c); }
        double getPrice() { return 150.0; }
        String getType() { return "REGULAR"; }
    }
    static class Premium extends Ticket {
        Premium(int c) { super(c); }
        double getPrice() { return 250.0; }
        String getType() { return "PREMIUM"; }
    }
    static class Recliner extends Ticket {
        Recliner(int c) { super(c); }
        double getPrice() { return 400.0; }
        String getType() { return "RECLINER"; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Ticket[] tickets = new Ticket[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int count = scanner.nextInt();
            if (type.equals("REGULAR")) tickets[i] = new Regular(count);
            else if (type.equals("PREMIUM")) tickets[i] = new Premium(count);
            else tickets[i] = new Recliner(count);
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double amt = tickets[i].getTotal();
            System.out.printf("%s: %.2f\n", tickets[i].getType(), amt);
            total += amt;
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
