import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scanner.nextInt();
        }
        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = scanner.nextInt();
        }
        int[] merged = mergeSortedArrays(arr1, arr2);
        System.out.print("[");
        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i]);
            if (i < merged.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        scanner.close();
    }

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int p1 = 0, p2 = 0, p3 = 0;
        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] <= arr2[p2]) {
                result[p3++] = arr1[p1++];
            } else {
                result[p3++] = arr2[p2++];
            }
        }
        while (p1 < arr1.length) {
            result[p3++] = arr1[p1++];
        }
        while (p2 < arr2.length) {
            result[p3++] = arr2[p2++];
        }
        return result;
    }
}
