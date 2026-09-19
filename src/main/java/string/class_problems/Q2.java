import java.util.Scanner;

public class Q2 {
    static class Scorecard {
        private boolean[] results;
        private int count;

        public Scorecard(int maxQuestions) {
            this.results = new boolean[maxQuestions];
            this.count = 0;
        }

        public void recordAnswer(boolean isCorrect) {
            if (this.count < this.results.length) {
                this.results[this.count] = isCorrect;
                this.count++;
            }
        }

        public int getScore() {
            int score = 0;
            for (int i = 0; i < this.count; i++) {
                if (this.results[i]) {
                    score++;
                }
            }
            return score;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        Scorecard sc = new Scorecard(scanner.nextInt());
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            sc.recordAnswer(scanner.nextBoolean());
        }
        System.out.println(sc.getScore());
        scanner.close();
    }
}
