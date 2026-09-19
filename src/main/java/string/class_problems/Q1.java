import java.util.Scanner;

public class Q1 {
    static class PiggyBank {
        private double savings;
        private final String id;

        public PiggyBank(String id) {
            this.id = id;
            this.savings = 0;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                this.savings += amount;
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= this.savings) {
                this.savings -= amount;
            }
        }

        public double getSavings() {
            return this.savings;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) {
            scanner.close();
            return;
        }
        PiggyBank pb = new PiggyBank(scanner.next());
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String op = scanner.next();
            double amt = scanner.nextDouble();
            if (op.equals("deposit")) pb.deposit(amt);
            else if (op.equals("withdraw")) pb.withdraw(amt);
        }
        System.out.println(pb.getSavings());
        scanner.close();
    }
}
