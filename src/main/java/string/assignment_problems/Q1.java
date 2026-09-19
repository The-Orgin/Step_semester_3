import java.util.Scanner;

public class Q1 {
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
        int[] answer = productExceptSelf(nums);
        System.out.print("[");
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
            if (i < answer.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        scanner.close();
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right = right * nums[i];
        }
        return answer;
    }
}
