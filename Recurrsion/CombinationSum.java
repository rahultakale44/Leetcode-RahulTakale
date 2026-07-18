import java.util.*;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private static void backtrack(
            int[] candidates,
            int remaining,
            int start,
            List<Integer> current,
            List<List<Integer>> result
    ) {

        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (remaining < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            current.add(candidates[i]);

            backtrack(candidates, remaining - candidates[i], i, current, result);

            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;

        System.out.println(combinationSum(candidates1, target1));
        System.out.println(combinationSum(candidates2, target2));
    }
}