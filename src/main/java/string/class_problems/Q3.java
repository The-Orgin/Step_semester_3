import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        double[] heights = new double[n];
        double[] weights = new double[n];
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextDouble();
            weights[i] = scanner.nextDouble();
        }
        printWellnessReport(heights, weights);
        scanner.close();
    }
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        }
        if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        }
        if (bmi >= 25.0 && bmi <= 29.9) {
            return "Overweight";
        }
        return "Obese";
    }
    public static void printWellnessReport(double[] heights, double[] weights) {
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %d - Height: %.2f m, Weight: %.2f kg | BMI: %.2f | Status: %s\n", (i + 1), heights[i], weights[i], bmi, status);
        }
    }
}

