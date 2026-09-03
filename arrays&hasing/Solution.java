public class Solution {
    public boolean uniformArray(int[] nums1) {
        int minVal = Integer.MAX_VALUE;
        boolean hasOdd = false;

        for (int num : nums1) {
            if (num < minVal) {
                minVal = num;
            }
            if (num % 2 != 0) {
                hasOdd = true;
            }
        }

        // 1. Min element is odd -> Can make all elements odd
        // 2. No odd elements exist -> All elements are already even
        return (minVal % 2 != 0) || !hasOdd;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] nums1 = {1, 4, 7};
        System.out.println("Test Case 1: " + sol.uniformArray(nums1)); // Expected: true

        // Test Case 2
        int[] nums2 = {2, 3};
        System.out.println("Test Case 2: " + sol.uniformArray(nums2)); // Expected: false
    }
}