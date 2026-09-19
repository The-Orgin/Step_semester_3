import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        System.out.println(maxProfit(prices));
        scanner.close();
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minPrice = prices[0];
        int maxProf = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProf) {
                    maxProf = profit;
                }
            }
        }
        return maxProf;
    }
}
