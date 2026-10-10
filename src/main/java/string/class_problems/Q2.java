import java.util.Scanner;

public class Q2 {
    static abstract class Item {
        String title;
        Item(String title) { this.title = title; }
        abstract int getDays();
    }
    static class Book extends Item {
        Book(String title) { super(title); }
        int getDays() { return 14; }
    }
    static class DVD extends Item {
        DVD(String title) { super(title); }
        int getDays() { return 7; }
    }
    static class Magazine extends Item {
        Magazine(String title) { super(title); }
        int getDays() { return 3; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            int spaceIdx = line.indexOf(" ");
            String type = line.substring(0, spaceIdx);
            String title = line.substring(spaceIdx + 1).replace("\"", "");
            if (type.equals("BOOK")) items[i] = new Book(title);
            else if (type.equals("DVD")) items[i] = new DVD(title);
            else items[i] = new Magazine(title);
        }
        java.time.LocalDate current = java.time.LocalDate.of(2023, 10, 26);
        for (int i = 0; i < n; i++) {
            java.time.LocalDate due = current.plusDays(items[i].getDays());
            System.out.println(items[i].title + ": " + due);
        }
        scanner.close();
    }
}
