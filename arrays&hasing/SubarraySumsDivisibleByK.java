import java.util.HashMap;

public class SubarraySumsDivisibleByK {

    public static int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            sum += num;

            int remainder = ((sum % k) + k) % k;

            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 5, 0, -2, -3, 1};
        int k1 = 5;

        int[] nums2 = {5};
        int k2 = 9;

        System.out.println(subarraysDivByK(nums1, k1)); // 7
        System.out.println(subarraysDivByK(nums2, k2)); // 0
    }
}