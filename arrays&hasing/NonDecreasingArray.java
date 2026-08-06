public class NonDecreasingArray {

    public static boolean checkPossibility(int[] nums) {

        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] > nums[i + 1]) {

                count++;

                if (count > 1) {
                    return false;
                }

                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1];
                } else {
                    nums[i + 1] = nums[i];
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 2, 3};
        int[] nums2 = {4, 2, 1};
        int[] nums3 = {3, 4, 2, 3};

        System.out.println(checkPossibility(nums1)); // true
        System.out.println(checkPossibility(nums2)); // false
        System.out.println(checkPossibility(nums3)); // false
    }
}