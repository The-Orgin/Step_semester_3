import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = scanner.nextInt();
        System.out.println(java.util.Arrays.toString(findTopThreeScores(scores)));
        scanner.close();
    }
    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for (int i = 0; i < scores.length; i++) {
            int s = scores[i];
            if (s > first) {
                third = second;
                second = first;
                first = s;
            } else if (s > second) {
                third = second;
                second = s;
            } else if (s > third) {
                third = s;
            }
        }
        return new int[]{first, second, third};
    }
}
