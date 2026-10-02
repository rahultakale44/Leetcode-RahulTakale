
public class LargestElementAfterMergeOperations {

    public static long maxArrayValue(int[] nums) {
        long current = nums[nums.length - 1];
        long answer = current;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= current) {
                current += nums[i];
            } else {
                current = nums[i];
            }

            answer = Math.max(answer, current);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 3, 7, 9, 3};
        int[] nums2 = {5, 3, 3};

        System.out.println("Input: [2, 3, 7, 9, 3]");
        System.out.println("Output: " + maxArrayValue(nums1));

        System.out.println();

        System.out.println("Input: [5, 3, 3]");
        System.out.println("Output: " + maxArrayValue(nums2));
    }
}