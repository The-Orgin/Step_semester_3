import java.util.Scanner;

public class Q1 {
    static abstract class Plot {
        String owner;
        Plot(String o) { owner = o; }
        abstract double getArea();
        abstract String getType();
    }
    static class Circle extends Plot {
        double radius;
        Circle(String o, double r) { super(o); radius = r; }
        double getArea() { return Math.PI * radius * radius; }
        String getType() { return "CIRCLE"; }
    }
    static class Rectangle extends Plot {
        double length, width;
        Rectangle(String o, double l, double w) { super(o); length = l; width = w; }
        double getArea() { return length * width; }
        String getType() { return "RECTANGLE"; }
    }
    static class Triangle extends Plot {
        double base, height;
        Triangle(String o, double b, double h) { super(o); base = b; height = h; }
        double getArea() { return 0.5 * base * height; }
        String getType() { return "TRIANGLE"; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Plot[] plots = new Plot[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String owner = scanner.next();
            if (type.equals("CIRCLE")) plots[i] = new Circle(owner, scanner.nextDouble());
            else if (type.equals("RECTANGLE")) plots[i] = new Rectangle(owner, scanner.nextDouble(), scanner.nextDouble());
            else plots[i] = new Triangle(owner, scanner.nextDouble(), scanner.nextDouble());
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double a = plots[i].getArea();
            System.out.printf("%s (%s): %.2f\n", plots[i].owner, plots[i].getType(), a);
            total += a;
        }
        System.out.printf("Total Area: %.2f\n", total);
        scanner.close();
    }
}
