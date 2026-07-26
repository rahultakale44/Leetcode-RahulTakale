import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        int maxLength = 1;

        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};

        System.out.println(lengthOfLIS(nums1)); // 4
        System.out.println(lengthOfLIS(nums2)); // 4
        System.out.println(lengthOfLIS(nums3)); // 1
    }
}