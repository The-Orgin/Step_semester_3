import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = scanner.nextInt();
        int bonus = scanner.nextInt();
        curveScores(scores, bonus);
        System.out.println(java.util.Arrays.toString(scores));
        scanner.close();
    }
    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }
}
