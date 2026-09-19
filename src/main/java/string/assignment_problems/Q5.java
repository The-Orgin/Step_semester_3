import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }
        String review = scanner.nextLine();
        classifyWordLengths(review);
        scanner.close();
    }
    public static void classifyWordLengths(String review) {
        String[] words = review.split("\\s+");
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i].replaceAll("[^a-zA-Z]", "");
            if (word.length() == 0) {
                continue;
            }
            int len = word.length();
            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }
        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }
}

