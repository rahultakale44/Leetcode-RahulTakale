import java.util.*;

public class SortCharactersByFrequency {

    public static String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );

        maxHeap.addAll(map.keySet());

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {

            char ch = maxHeap.poll();
            int frequency = map.get(ch);

            for (int i = 0; i < frequency; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(frequencySort("tree"));   // eert or eetr
        System.out.println(frequencySort("cccaaa")); // cccaaa or aaaccc
        System.out.println(frequencySort("Aabb"));   // bbAa or bbaA
    }
}