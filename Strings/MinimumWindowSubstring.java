import java.util.*;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int required = need.size();
        int formed = 0;

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);

            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            if (need.containsKey(rightChar) &&
                window.get(rightChar).intValue() == need.get(rightChar).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {

                int currentLength = right - left + 1;

                if (currentLength < minLength) {
                    minLength = currentLength;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar) &&
                    window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(startIndex, startIndex + minLength);
    }

    public static void main(String[] args) {

        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(minWindow("a", "a"));              // a
        System.out.println(minWindow("a", "aa"));             // ""
    }
}