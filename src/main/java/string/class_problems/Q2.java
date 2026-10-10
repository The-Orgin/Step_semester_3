import java.util.Scanner;

public class Q2 {
    static abstract class Staff {
        String name;
        Staff(String n) { name = n; }
        abstract double getPay();
    }
    static class FullTime extends Staff {
        double salary;
        FullTime(String n, double s) { super(n); salary = s; }
        double getPay() { return salary; }
    }
    static class Hourly extends Staff {
        double hours, rate;
        Hourly(String n, double h, double r) { super(n); hours = h; rate = r; }
        double getPay() {
            if (hours <= 40) return hours * rate;
            return (40 * rate) + ((hours - 40) * 1.5 * rate);
        }
    }
    static class Intern extends Staff {
        double stipend;
        Intern(String n, double s) { super(n); stipend = s; }
        double getPay() { return stipend; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Staff[] staffList = new Staff[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            if (type.equals("FULLTIME")) staffList[i] = new FullTime(name, scanner.nextDouble());
            else if (type.equals("HOURLY")) staffList[i] = new Hourly(name, scanner.nextDouble(), scanner.nextDouble());
            else staffList[i] = new Intern(name, scanner.nextDouble());
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double p = staffList[i].getPay();
            System.out.printf("%s: %.2f\n", staffList[i].name, p);
            total += p;
        }
        System.out.printf("Total Payroll: %.2f\n", total);
        scanner.close();
    }
}
