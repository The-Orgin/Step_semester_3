import java.util.Scanner;

public class Q1 {
    static abstract class Customer {
        double amount;
        Customer(double a) { amount = a; }
        abstract double getFinal();
        abstract String getType();
    }
    static class Student extends Customer {
        Student(double a) { super(a); }
        double getFinal() { return amount * 0.90; }
        String getType() { return "STUDENT"; }
    }
    static class Staff extends Customer {
        Staff(double a) { super(a); }
        double getFinal() { return amount * 0.95; }
        String getType() { return "STAFF"; }
    }
    static class Guest extends Customer {
        Guest(double a) { super(a); }
        double getFinal() { return amount + 10.0; }
        String getType() { return "GUEST"; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Customer[] customers = new Customer[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double a = scanner.nextDouble();
            if (type.equals("STUDENT")) customers[i] = new Student(a);
            else if (type.equals("STAFF")) customers[i] = new Staff(a);
            else customers[i] = new Guest(a);
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double f = customers[i].getFinal();
            System.out.printf("%s: %.2f\n", customers[i].getType(), f);
            total += f;
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
