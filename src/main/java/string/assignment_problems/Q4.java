import java.util.Scanner;

public class Q4 {
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
        System.out.println(subarraySum(nums, k));
        scanner.close();
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        java.util.HashMap<Integer, Integer> prefixSumFreq = new java.util.HashMap<>();
        prefixSumFreq.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (prefixSumFreq.containsKey(currentSum - k)) {
                count += prefixSumFreq.get(currentSum - k);
            }
            prefixSumFreq.put(currentSum, prefixSumFreq.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}
