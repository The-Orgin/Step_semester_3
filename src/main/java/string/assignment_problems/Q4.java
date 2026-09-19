import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        int[] sectionA = new int[n];
        for (int i = 0; i < n; i++) {
            sectionA[i] = scanner.nextInt();
        }
        int[] sectionB = new int[n];
        for (int i = 0; i < n; i++) {
            sectionB[i] = scanner.nextInt();
        }
        analyzeInventory(sectionA, sectionB);
        scanner.close();
    }
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;
        int highestQuantity = -1;
        String highestLocation = "";
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestLocation = "Section A, Item " + (i + 1);
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestLocation = "Section B, Item " + (i + 1);
            }
        }
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB + " | Status: " + status + " | Highest Quantity: " + highestQuantity + " (" + highestLocation + ")");
    }
}

