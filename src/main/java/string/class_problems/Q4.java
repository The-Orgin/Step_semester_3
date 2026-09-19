import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int rows = scanner.nextInt();
        int[][] grid = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int cols = scanner.nextInt();
            grid[i] = new int[cols];
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        int threshold = scanner.nextInt();
        System.out.println(classifyRows(grid, threshold));
        scanner.close();
    }
    static double rowAverage(int[] row) {
        if (row.length == 0) return 0.0;
        double sum = 0;
        for (int i = 0; i < row.length; i++) sum += row[i];
        return sum / row.length;
    }
    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            sb.append("Row ").append(i).append(": ");
            if (avg >= threshold) {
                sb.append("Buzzing Zone");
            } else {
                sb.append("Quiet Zone");
            }
            if (i < seatingScores.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
}
