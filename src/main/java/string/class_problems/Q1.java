import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wins = 0;
        int losses = 0;
        int draws = 0;
        String[] rps = {"Rock", "Paper", "Scissors"};
        for (int i = 1; i <= 5; i++) {
            String playerMove = scanner.nextLine().trim();
            int randIndex = (int) (Math.random() * 3);
            String computerMove = rps[randIndex];
            String result = playRound(playerMove, computerMove);
            System.out.println("Round " + i + " - Player: " + playerMove + ", Computer: " + computerMove + " | Result: " + result);
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }
        double winPercentage = (wins / 5.0) * 100.0;
        System.out.println("Final Summary (after 5 rounds)");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
        scanner.close();
    }
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
}

