import java.util.*;

public class SlidingWindowMedian {

    static PriorityQueue<Integer> small;
    static PriorityQueue<Integer> large;
    static HashMap<Integer, Integer> delayed;

    static int smallSize;
    static int largeSize;
    static int k;

    public static double[] medianSlidingWindow(int[] nums, int windowSize) {

        k = windowSize;

        small = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        large = new PriorityQueue<>();
        delayed = new HashMap<>();

        smallSize = 0;
        largeSize = 0;

        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {

            addNum(nums[i]);

            if (i >= k) {
                removeNum(nums[i - k]);
            }

            if (i >= k - 1) {
                result[i - k + 1] = getMedian();
            }
        }

        return result;
    }

    private static void addNum(int num) {

        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            smallSize++;
        } else {
            large.offer(num);
            largeSize++;
        }

        balance();
    }

    private static void removeNum(int num) {

        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

        if (num <= small.peek()) {
            smallSize--;

            if (num == small.peek()) {
                prune(small);
            }

        } else {
            largeSize--;

            if (!large.isEmpty() && num == large.peek()) {
                prune(large);
            }
        }

        balance();
    }

    private static void balance() {

        if (smallSize > largeSize + 1) {

            large.offer(small.poll());
            smallSize--;
            largeSize++;

            prune(small);

        } else if (smallSize < largeSize) {

            small.offer(large.poll());
            largeSize--;
            smallSize++;

            prune(large);
        }
    }

    private static void prune(PriorityQueue<Integer> heap) {

        while (!heap.isEmpty()) {

            int num = heap.peek();

            if (!delayed.containsKey(num)) {
                break;
            }

            delayed.put(num, delayed.get(num) - 1);

            if (delayed.get(num) == 0) {
                delayed.remove(num);
            }

            heap.poll();
        }
    }

    private static double getMedian() {

        if (k % 2 == 1) {
            return small.peek();
        }

        return ((long) small.peek() + (long) large.peek()) / 2.0;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println(Arrays.toString(medianSlidingWindow(nums, k)));
    }
}