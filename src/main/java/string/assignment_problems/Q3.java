import java.util.Scanner;

public class Q3 {
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
        int[][] result = threeSum(nums);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print("[" + result[i][0] + ", " + result[i][1] + ", " + result[i][2] + "]");
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        scanner.close();
    }

    public static int[][] threeSum(int[] nums) {
        java.util.Arrays.sort(nums);
        java.util.List<int[]> triplets = new java.util.ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    triplets.add(new int[]{nums[i], nums[left], nums[right]});
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        int[][] res = new int[triplets.size()][3];
        for (int i = 0; i < triplets.size(); i++) {
            res[i] = triplets.get(i);
        }
        return res;
    }
}
