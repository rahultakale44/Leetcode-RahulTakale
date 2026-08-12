public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int maxCount = 0;

        for (int num : nums) {

            if (num == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 1, 0, 1, 1, 1};
        int[] nums2 = {1, 0, 1, 1, 0, 1};

        System.out.println(findMaxConsecutiveOnes(nums1)); // 3
        System.out.println(findMaxConsecutiveOnes(nums2)); // 2
    }
}