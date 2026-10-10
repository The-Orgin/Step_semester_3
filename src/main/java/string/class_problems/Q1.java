import java.util.Scanner;

public class Q1 {
    static abstract class Payment {
        double amount;
        Payment(double amount) { this.amount = amount; }
        abstract double getFee();
        abstract String getType();
        double getAdjusted() { return amount + getFee(); }
    }
    static class Card extends Payment {
        Card(double amount) { super(amount); }
        double getFee() { return amount * 0.02; }
        String getType() { return "CARD"; }
    }
    static class Wallet extends Payment {
        Wallet(double amount) { super(amount); }
        double getFee() { return amount * 0.01; }
        String getType() { return "WALLET"; }
    }
    static class BankTransfer extends Payment {
        BankTransfer(double amount) { super(amount); }
        double getFee() { return 0.0; }
        String getType() { return "BANKTRANSFER"; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Payment[] payments = new Payment[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amt = scanner.nextDouble();
            if (type.equals("CARD")) payments[i] = new Card(amt);
            else if (type.equals("WALLET")) payments[i] = new Wallet(amt);
            else payments[i] = new BankTransfer(amt);
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double adj = payments[i].getAdjusted();
            System.out.printf("%s: %.2f\n", payments[i].getType(), adj);
            total += adj;
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}
