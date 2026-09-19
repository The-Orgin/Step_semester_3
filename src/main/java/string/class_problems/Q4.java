import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }
        String text = scanner.nextLine();
        char result = findFirstNonRepeatingChar(text);
        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
        scanner.close();
    }
    public static char findFirstNonRepeatingChar(String text) {
        int[] frequencies = new int[256];
        for (int i = 0; i < text.length(); i++) {
            frequencies[text.charAt(i)]++;
        }
        for (int i = 0; i < text.length(); i++) {
            if (frequencies[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return '\0';
    }
}

