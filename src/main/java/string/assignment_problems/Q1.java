import java.util.Scanner;

public class Q1 {
    static class BookInventory {
        String title;
        String author;
        int copiesAvailable;
        public BookInventory(String title, String author, int copiesAvailable) {
            this.title = title;
            this.author = author;
            this.copiesAvailable = copiesAvailable;
        }
        public void printEntry() {
            System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookInventory[] books = new BookInventory[4];
        if (scanner.hasNextLine()) {
            for (int i = 0; i < 4; i++) {
                String title = scanner.nextLine();
                String author = scanner.nextLine();
                int copies = Integer.parseInt(scanner.nextLine());
                books[i] = new BookInventory(title, author, copies);
            }
        } else {
            books[0] = new BookInventory("Clean Code", "Robert C. Martin", 3);
            books[1] = new BookInventory("Effective Java", "Joshua Bloch", 5);
            books[2] = new BookInventory("Refactoring", "Martin Fowler", 0);
            books[3] = new BookInventory("Design Patterns", "GoF", 2);
        }
        for (int i = 0; i < books.length; i++) {
            books[i].printEntry();
        }
        scanner.close();
    }
}
