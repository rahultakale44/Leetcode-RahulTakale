import java.util.HashMap;

public class NumberOfGoodPairs {

    public static int numIdenticalPairs(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;

        for (int num : nums) {

            int previousFrequency = map.getOrDefault(num, 0);

            count = count + previousFrequency;

            map.put(num, previousFrequency + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1, 1, 3};

        int ans = numIdenticalPairs(nums);

        System.out.println(ans);
    }
}
