import java.util.Scanner;

public class Q4 {
    static abstract class Employee {
        String name;
        double salary;
        Employee(String n, double s) { name = n; salary = s; }
        abstract double getBonus();
    }
    static class FullTime extends Employee {
        FullTime(String n, double s) { super(n, s); }
        double getBonus() { return salary * 0.10; }
    }
    static class PartTime extends Employee {
        PartTime(String n, double s) { super(n, s); }
        double getBonus() { return salary * 0.05; }
    }
    static class Intern extends Employee {
        Intern(String n, double s) { super(n, s); }
        double getBonus() { return 2000.0; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Employee[] emps = new Employee[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double s = scanner.nextDouble();
            if (type.equals("FULLTIME")) emps[i] = new FullTime(name, s);
            else if (type.equals("PARTTIME")) emps[i] = new PartTime(name, s);
            else emps[i] = new Intern(name, s);
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double b = emps[i].getBonus();
            System.out.printf("%s: %.2f\n", emps[i].name, b);
            total += b;
        }
        System.out.printf("Total Bonus: %.2f\n", total);
        scanner.close();
    }
}
