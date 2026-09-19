import java.util.Scanner;

public class Q5 {
    static class Cart {
        private double[] prices;
        private int count;
        private final String cartId;

        public Cart(String cartId, int maxSize) {
            this.cartId = cartId;
            this.prices = new double[maxSize];
            this.count = 0;
        }

        public void addItem(double price) {
            if (this.count < this.prices.length) {
                this.prices[this.count] = price;
                this.count++;
            }
        }

        public double getTotal() {
            double sum = 0;
            for (int i = 0; i < this.count; i++) {
                sum += this.prices[i];
            }
            return sum;
        }

        public int getItemCount() {
            return this.count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) {
            scanner.close();
            return;
        }
        Cart cart = new Cart(scanner.next(), scanner.nextInt());
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            cart.addItem(scanner.nextDouble());
        }
        System.out.println(cart.getTotal());
        System.out.println(cart.getItemCount());
        scanner.close();
    }
}
