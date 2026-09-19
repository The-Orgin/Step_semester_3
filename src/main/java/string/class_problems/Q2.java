import java.util.Scanner;

public class Q2 {
    static class MessWallet {
        private double balance;
        public MessWallet(double openingBalance) {
            if (openingBalance < 0) {
                this.balance = 0;
                System.out.println("Warning: Opening balance cannot be negative. Set to 0.");
            } else {
                this.balance = openingBalance;
            }
        }
        public void topUp(double amount) {
            if (amount <= 0) {
                System.out.println("Top-up amount must be positive.");
            } else {
                this.balance += amount;
                System.out.println("Balance after top-up: " + this.balance);
            }
        }
        public void deduct(double amount) {
            if (amount > this.balance) {
                System.out.println("Deduct rejected: insufficient balance");
            } else {
                this.balance -= amount;
            }
        }
        public double getBalance() {
            return this.balance;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextDouble()) {
            double opening = scanner.nextDouble();
            MessWallet wallet = new MessWallet(opening);
            double topUpAmount = scanner.nextDouble();
            wallet.topUp(topUpAmount);
            double deductAmount = scanner.nextDouble();
            wallet.deduct(deductAmount);
            System.out.println("Final balance: " + wallet.getBalance());
        }
        scanner.close();
    }
}
