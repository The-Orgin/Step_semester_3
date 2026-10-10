import java.util.Scanner;

public class Q3 {
    static abstract class Item {
        String title;
        int days;
        Item(String t, int d) { title = t; days = d; }
        abstract double getFine();
    }
    static class Book extends Item {
        Book(String t, int d) { super(t, d); }
        double getFine() { return days * 2.0; }
    }
    static class DVD extends Item {
        DVD(String t, int d) { super(t, d); }
        double getFine() {
            double f = days * 5.0;
            return f > 50.0 ? 50.0 : f;
        }
    }
    static class Magazine extends Item {
        Magazine(String t, int d) { super(t, d); }
        double getFine() { return days * 1.0; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int d = scanner.nextInt();
            if (type.equals("BOOK")) items[i] = new Book(title, d);
            else if (type.equals("DVD")) items[i] = new DVD(title, d);
            else items[i] = new Magazine(title, d);
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double f = items[i].getFine();
            System.out.printf("%s: %.2f\n", items[i].title, f);
            total += f;
        }
        System.out.printf("Total Fines: %.2f\n", total);
        scanner.close();
    }
}
