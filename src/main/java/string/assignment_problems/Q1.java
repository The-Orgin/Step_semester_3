import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        int[] seatNumbers = new int[n];
        for (int i = 0; i < n; i++) {
            seatNumbers[i] = scanner.nextInt();
        }
        checkDuplicateSeats(seatNumbers);
        scanner.close();
    }
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean found = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}

