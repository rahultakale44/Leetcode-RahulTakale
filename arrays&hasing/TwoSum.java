import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int current = nums[i];
            int required = target - current;

            if (map.containsKey(required)) {
                return new int[] { map.get(required), i };
            }

            map.put(current, i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println(Arrays.toString(result));
    }
}