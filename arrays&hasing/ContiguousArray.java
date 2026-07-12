import java.util.HashMap;

public class ContiguousArray {

    public static int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }

            if (map.containsKey(sum)) {
                int previousIndex = map.get(sum);
                int length = i - previousIndex;

                maxLength = Math.max(maxLength, length);
            } else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] nums1 = {0, 1};
        int[] nums2 = {0, 1, 0};
        int[] nums3 = {0, 0, 1, 0, 0, 0, 1, 1};

        System.out.println(findMaxLength(nums1)); // 2
        System.out.println(findMaxLength(nums2)); // 2
        System.out.println(findMaxLength(nums3)); // 6
    }
}