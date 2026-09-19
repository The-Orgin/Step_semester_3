import java.util.Scanner;

public class Q5 {
    static class Candidate implements Comparable<Candidate> {
        String name;
        double cgpa;
        int codingScore;
        double compositeScore;
        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
            this.compositeScore = cgpa * 10.0 + codingScore * 0.5;
        }
        public int compareTo(Candidate other) {
            if (this.compositeScore < other.compositeScore) return 1;
            if (this.compositeScore > other.compositeScore) return -1;
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Candidate[] candidates = new Candidate[n];
        for (int i = 0; i < n; i++) {
            candidates[i] = new Candidate(scanner.next(), scanner.nextDouble(), scanner.nextInt());
        }
        System.out.println(shortlistAndRank(candidates));
        scanner.close();
    }
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }
    static String shortlistAndRank(Candidate[] candidates) {
        java.util.List<Candidate> eligible = new java.util.ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            Candidate c = candidates[i];
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                eligible.add(c);
            }
        }
        Candidate[] arr = new Candidate[eligible.size()];
        for (int i = 0; i < arr.length; i++) arr[i] = eligible.get(i);
        java.util.Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(i + 1).append(". ").append(arr[i].name).append(" (").append(arr[i].compositeScore).append(")");
            if (i < arr.length - 1) sb.append(" | ");
        }
        return sb.toString();
    }
}
