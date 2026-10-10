import java.util.Scanner;

public class Q3 {
    static abstract class Student {
        String name;
        Student(String n) { name = n; }
        abstract double getFee();
    }
    static class DayScholar extends Student {
        DayScholar(String n) { super(n); }
        double getFee() { return 40000.0 + 12000.0; }
    }
    static class Hosteller extends Student {
        Hosteller(String n) { super(n); }
        double getFee() { return 40000.0 + 60000.0; }
    }
    static class Scholarship extends Student {
        Scholarship(String n) { super(n); }
        double getFee() { return 20000.0 + 12000.0; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            if (type.equals("DAY_SCHOLAR")) students[i] = new DayScholar(name);
            else if (type.equals("HOSTELLER")) students[i] = new Hosteller(name);
            else students[i] = new Scholarship(name);
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double fee = students[i].getFee();
            System.out.printf("%s: %.2f\n", students[i].name, fee);
            total += fee;
        }
        System.out.printf("Total Collected: %.2f\n", total);
        scanner.close();
    }
}
