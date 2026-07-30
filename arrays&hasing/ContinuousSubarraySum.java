import java.util.HashMap;

public class ContinuousSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            int remainder = sum % k;

            if (map.containsKey(remainder)) {

                int previousIndex = map.get(remainder);

                if (i - previousIndex >= 2) {
                    return true;
                }

            } else {
                map.put(remainder, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;

        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 6;

        int[] nums3 = {23, 2, 6, 4, 7};
        int k3 = 13;

        System.out.println(checkSubarraySum(nums1, k1)); // true
        System.out.println(checkSubarraySum(nums2, k2)); // true
        System.out.println(checkSubarraySum(nums3, k3)); // false
    }
}
