import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double[] scores = new double[n];
        for (int i = 0; i < n; i++) scores[i] = scanner.nextDouble();
        int cIdx = scanner.nextInt();
        int vcIdx = scanner.nextInt();
        applyMultipliers(scores, cIdx, vcIdx);
        System.out.println(java.util.Arrays.toString(scores));
        scanner.close();
    }
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (captainIndex >= 0 && captainIndex < playerScores.length) {
            playerScores[captainIndex] *= 2.0;
        }
        if (viceCaptainIndex >= 0 && viceCaptainIndex < playerScores.length) {
            playerScores[viceCaptainIndex] *= 1.5;
        }
    }
}
