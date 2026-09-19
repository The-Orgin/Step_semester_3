import java.util.Scanner;

public class Q5 {
    static class Player implements Comparable<Player> {
        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;
        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }
        public int compareTo(Player other) {
            if (this.battingAverage < other.battingAverage) return 1;
            if (this.battingAverage > other.battingAverage) return -1;
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            players[i] = new Player(scanner.next(), scanner.nextInt(), scanner.nextDouble(), scanner.nextBoolean());
        }
        System.out.println(draftAndRank(players));
        scanner.close();
    }
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }
    static String draftAndRank(Player[] players) {
        java.util.List<Player> draftable = new java.util.ArrayList<>();
        for (int i = 0; i < players.length; i++) {
            Player p = players[i];
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftable.add(p);
            }
        }
        Player[] arr = new Player[draftable.size()];
        for (int i = 0; i < arr.length; i++) arr[i] = draftable.get(i);
        java.util.Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(i + 1).append(". ").append(arr[i].name);
            if (i < arr.length - 1) sb.append(" | ");
        }
        return sb.toString();
    }
}
