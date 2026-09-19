import java.util.Scanner;

public class Q2 {
    static class PayrollAccount {
        private double basicSalary;
        private double bonus;
        public PayrollAccount(double basicSalary) {
            if (basicSalary < 0) {
                this.basicSalary = 0;
                System.out.println("Warning: Basic salary cannot be negative. Set to 0.");
            } else {
                this.basicSalary = basicSalary;
            }
            this.bonus = 0;
        }
        public void creditBonus(double amount) {
            if (amount <= 0) {
                System.out.println("Bonus amount must be positive.");
            } else {
                this.bonus += amount;
                System.out.println("Bonus credited: Rs " + amount);
            }
        }
        public void deductTax(double percent) {
            if (percent < 0 || percent > 100) {
                System.out.println("Tax percentage must be between 0 and 100.");
            } else {
                this.basicSalary -= this.basicSalary * (percent / 100.0);
                System.out.println("Tax deducted: " + percent + "%");
            }
        }
        public double getNetSalary() {
            return this.basicSalary + this.bonus;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextDouble()) {
            double salary = scanner.nextDouble();
            PayrollAccount acc = new PayrollAccount(salary);
            double bonus = scanner.nextDouble();
            acc.creditBonus(bonus);
            double tax = scanner.nextDouble();
            acc.deductTax(tax);
            System.out.println("Net salary: Rs " + acc.getNetSalary());
        }
        scanner.close();
    }
}
