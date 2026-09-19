import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int[] rotated = rotateArray(nums, k);
        System.out.print("[");
        for (int i = 0; i < rotated.length; i++) {
            System.out.print(rotated[i]);
            if (i < rotated.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        scanner.close();
    }

    public static int[] rotateArray(int[] nums, int k) {
        if (nums.length == 0) return nums;
        k = k % nums.length;
        int[] newArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArray[i];
        }
        return nums;
    }
}
