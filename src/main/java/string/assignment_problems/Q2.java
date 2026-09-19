import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }
        String original = scanner.nextLine();
        String typed = scanner.nextLine();
        checkTypingAccuracy(original, typed);
        scanner.close();
    }
    public static void checkTypingAccuracy(String original, String typed) {
        int matchCount = 0;
        int firstMismatch = -1;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchCount++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }
        double accuracy = ((double) matchCount / original.length()) * 100.0;
        System.out.print("Matched: " + matchCount + "/" + original.length() + " | ");
        System.out.printf("Accuracy: %.2f%% | ", accuracy);
        if (firstMismatch == -1) {
            System.out.println("No Mismatches");
        } else {
            System.out.println("First Mismatch at position " + firstMismatch + " ('" + original.charAt(firstMismatch) + "' vs '" + typed.charAt(firstMismatch) + "')");
        }
    }
}

