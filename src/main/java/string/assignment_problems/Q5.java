import java.util.Scanner;

public class Q5 {
    static class Employee {
        String empName;
        double salary;
        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;
        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }
        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee e1 = new Employee("A", 100);
        Employee e2 = new Employee("B", 200);
        Employee e3 = new Employee("C", 300);
        Employee.printCompanyInfo();
        scanner.close();
    }
}
