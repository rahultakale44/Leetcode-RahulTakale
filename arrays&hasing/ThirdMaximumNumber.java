public class ThirdMaximumNumber {

    public static int thirdMax(int[] nums) {

        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int num : nums) {

            if (num == first || num == second || num == third) {
                continue;
            }

            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num > third) {
                third = num;
            }
        }

        if (third == Long.MIN_VALUE) {
            return (int) first;
        }

        return (int) third;
    }

    public static void main(String[] args) {

        int[] nums1 = {3, 2, 1};
        int[] nums2 = {1, 2};
        int[] nums3 = {2, 2, 3, 1};

        System.out.println(thirdMax(nums1)); // 1
        System.out.println(thirdMax(nums2)); // 2
        System.out.println(thirdMax(nums3)); // 1
    }
}