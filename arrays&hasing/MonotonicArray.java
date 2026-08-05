public class MonotonicArray {

    public static boolean isMonotonic(int[] nums) {

        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] > nums[i + 1]) {
                increasing = false;
            }

            if (nums[i] < nums[i + 1]) {
                decreasing = false;
            }
        }

        return increasing || decreasing;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 3};
        int[] nums2 = {6, 5, 4, 4};
        int[] nums3 = {1, 3, 2};

        System.out.println(isMonotonic(nums1)); // true
        System.out.println(isMonotonic(nums2)); // true
        System.out.println(isMonotonic(nums3)); // false
    }
}